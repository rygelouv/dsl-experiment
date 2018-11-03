fun meetup(func: MeetupBuilder.() -> Unit): Meetup = MeetupBuilder().apply { func() }.build()

/*fun MeetupBuilder.talk(func: TalkBuilder.() -> Unit) {
    talks.add(TalkBuilder().apply{ func() }.build())
}*/

@MeetupDsl
class ListOfTalk: ArrayList<Talk>() {
    fun talk(func: TalkBuilder.() -> Unit) {
        add(TalkBuilder().apply{ func() }.build())
    }
}

@MeetupDsl
class MeetupBuilder {
    var group: String? = null
    var title: String? = null
    var date: String? = null
    var start : Int = 0
    var talks = mutableListOf<Talk>()

    fun talks(func: ListOfTalk.() -> Unit) {
        talks.addAll(ListOfTalk().apply(func))
    }

    fun build() : Meetup = Meetup(group, title, date, talks).apply { start }
}

infix fun Int.at(value: Int): Int? {
    return value
}

@MeetupDsl
class TalkBuilder {
    var title: String? = null
    var speaker: String? = null
    var hour: String? = null
    var duractionLimit: String? = null
    var questionsAllowed: String? = null

    fun build() : Talk = Talk(title, speaker, hour, duractionLimit, questionsAllowed)

    enum class RESPONSE {
        YES,
        NO,
        MAYBE
    }
}


fun main(args: Array<String>) {
    val dslMeetup = meetup {
        date = "slfnq"
        group = "DAUG"
        title = "title"
        start at 34
        talks {
            talk {
                title = "Super talk"
                speaker = "Souleymane Super Sidibe"
                hour = "5am"

            }
            talk {
                title = "Super talk"
                speaker = "Souleymane Super Sidibe"
                hour = "5am"
            }
        }
    }
    println(dslMeetup)
}



fun String.test() {
    //this.toUpperCase()
    val a1 = ArrayList<String>()
    val a2 = mutableListOf<String>()

    a1.addAll(a2)
}