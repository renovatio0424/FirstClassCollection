fun main() {
    val adjustments = Adjustment.newAdjustment()
    val mutableClip = ClipBefore(adjustments)

    mutableClip.showAdjustments()
    /**
     * RESULT
     *
     * BRIGHTNESS/0.5
     * CONTRAST/0.5
     * SATURATION/0.5
     * */

    adjustments[0].factor = 0.7f
    adjustments[1].factor = 0.4f
    adjustments[2].factor = 0.1f

    //컬렉션의 불변을 보장하기 어렵다
    mutableClip.showAdjustments()
    /**
     * RESULT
     *
     * BRIGHTNESS/0.7
     * CONTRAST/0.4
     * SATURATION/0.1
     * */
}