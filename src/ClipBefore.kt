class ClipBefore {
    private val adjustmentList: List<Adjustment> = Adjustment.newAdjustment()

    fun applyAdjustmentToEngine() {
        val brightness = getEngineValue(AdjustmentType.BRIGHTNESS)
        val contrast = getEngineValue(AdjustmentType.CONTRAST)
        val saturation = getEngineValue(AdjustmentType.SATURATION)

        println("apply adjustment brightness: $brightness")
        println("apply adjustment contrast: $contrast")
        println("apply adjustment saturation: $saturation")
    }

    // adjustment 에 대한 비즈니스 로직이 Clip 에 추가 되어야 했다...
    private fun getFactor(type: AdjustmentType): Float
            = adjustmentList.find { it.type == type }?.factor ?: 0f

    private fun getEngineValue(type: AdjustmentType): Float
            = getFactor(type) * 255f
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
