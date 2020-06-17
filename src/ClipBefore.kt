class ClipBefore {
    private val adjustmentList: List<Adjustment> = Adjustment.newAdjustment()

    //소유한 객체에서 해당 데이터를 관리하는 함수들 & 로직들이 필요하다
   fun getAppliedAdjustmentList(): List<Adjustment>
            = adjustmentList.filter { it.factor != 0.5f }
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
