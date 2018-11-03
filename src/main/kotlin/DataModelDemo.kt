data class Meetup(
        val group: String?,
        val title: String?,
        val date: String?,
        val talks : List<Talk>?
        //val talk: Talk?
) {
        var start : Int? = null


}

data class Talk(
        val title: String?,
        val speaker: String?,
        val hour: String?,
        val duractionLimit: String?,
        val questionsAllowed: String?
)


@DslMarker
annotation class MeetupDsl
