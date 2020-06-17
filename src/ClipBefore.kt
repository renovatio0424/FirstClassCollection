class ClipBefore() {
    private lateinit var adjustmentList: List<Adjustment>

    constructor(adjustmentList: List<Adjustment>?) : this() {
        this.adjustmentList = adjustmentList ?: Adjustment.newAdjustment()
    }

    fun applyAdjustmentToEngine() {
        val brightness = getEngineValue(AdjustmentType.BRIGHTNESS)
        val contrast = getEngineValue(AdjustmentType.CONTRAST)
        val saturation = getEngineValue(AdjustmentType.SATURATION)

        println("apply adjustment brightness: $brightness")
        println("apply adjustment contrast: $contrast")
        println("apply adjustment saturation: $saturation")
    }

    fun showAdjustments() {
        adjustmentList.forEach { println(it.type.name + " / " + it.factor) }
    }

    private fun getFactor(type: AdjustmentType): Float = adjustmentList.find { it.type == type }?.factor ?: 0f

    private fun getEngineValue(type: AdjustmentType): Float = getFactor(type) * 255f
}

//Before Refactoring
class Adjustment(
    //factor range : 0f ~ 1.0f
    var factor: Float,
    val type: AdjustmentType
) {

    companion object {
        fun newAdjustment(): List<Adjustment> = AdjustmentType.values().map { Adjustment(0.5f, it) }
    }
}

enum class AdjustmentType {
    BRIGHTNESS,
    CONTRAST,
    SATURATION
}
