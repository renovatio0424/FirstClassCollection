class ClipAfter {
    private val adjustments: Adjustments = Adjustments(listOf())

    //비즈니스에 종속적인 로직
    fun applyAdjustmentToEngine() {
        val brightness = adjustments.getEngineValue(AdjustmentType.BRIGHTNESS)
        val contrast = adjustments.getEngineValue(AdjustmentType.CONTRAST)
        val saturation = adjustments.getEngineValue(AdjustmentType.SATURATION)

        //apply Adjustments to Engine
        println("apply adjustment brightness: $brightness")
        println("apply adjustment contrast: $contrast")
        println("apply adjustment saturation: $saturation")
    }
}

//After Refactoring (First Class Collection)
class Adjustments() {
    private lateinit var adjustmentList: List<Adjustment>

    constructor(adjustmentList: List<Adjustment>?) : this() {
        this.adjustmentList = adjustmentList ?: Adjustment.newAdjustment()
    }

    private fun getFactor(type: AdjustmentType): Float
            = adjustmentList.find { it.type == type }?.factor ?: 0f

    fun getEngineValue(type: AdjustmentType): Float
            = getFactor(type) * 255f
}