package com.example.alphadecoder.utils

import com.example.alphadecoder.AppDetails
import com.example.alphadecoder.AssistantAction
import com.example.alphadecoder.Collection

object Repository {

    fun getAssistantMessage(): List<AssistantAction> {
        return listOf<AssistantAction>(
            AssistantAction(message = "Hello I am your assistant", type = 1),
            AssistantAction(message = "Would you like my help with something ?", type = 1),
            AssistantAction(message = "I can help you with following", type = 1),
            AssistantAction(
                type = 2, "",
                listOf<String>(
                    "App Search",
                    "Category Search",
                    "Open App",
                    "Uninstall App",
                    "Change Language"
                ),
            )
        )
    }

    fun getApplications(): List<AppDetails> {
        return listOf<AppDetails>(
            AppDetails(
                "Paytm -UPI, Money Transfer, Recharge, Bill Payment",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_da815BOhFqY6HAK7-9xWwxhVMAPQzCsGsw&usqp=CAU"
            ),
            AppDetails(
                "MX Player",
                "https://filmfare.wwmindia.com/content/2019/nov/indian-web-series-flames-111574763112.jpg"
            ),
            AppDetails(
                "Amazon Prime",
                "https://im.indiatimes.in/content/2021/Sep/241448122_226907436060727_3612715713474855933_n_613c58ca5e864.jpg?w=725&h=906"
            )

        )
    }

    fun getApplications2(): List<AppDetails> {
        return listOf<AppDetails>(
            AppDetails(
                "Paytm -UPI, Money Transfer, Recharge, Bill Payment",
                "https://static.c.realme.com/IN/thread/1308806095069773824.jpg"
            ),
            AppDetails(
                "MX Player",
                "https://99designs-blog.imgix.net/blog/wp-content/uploads/2017/04/attachment_52825669-e1492536222574.png?auto=format&q=60&fit=max&w=930"
            ),
            AppDetails(
                "Amazon Prime",
                "https://i.pinimg.com/736x/bd/c7/c3/bdc7c3cff06903a0d36db0fe5d4fd5c4--logo-app-app-icons.jpg"
            )

        )
    }

    fun getApplications3() : List<AppDetails>{
        return listOf<AppDetails>(
            AppDetails(
                "Moj Lite",
                "https://play-lh.googleusercontent.com/93H1tf40Tq_4rn9waqWa6Wm2wx_YBMfPuOsxbzovvrahm3ndyk6hdUzBzetmWTulsw7e"
            ),
            AppDetails(
                "CoinSwitch",
                "https://filmfare.wwmindia.com/content/2019/nov/indian-web-series-flames-111574763112.jpg"
            ),
            AppDetails(
                "Forest",
                "https://i.pinimg.com/736x/bd/c7/c3/bdc7c3cff06903a0d36db0fe5d4fd5c4--logo-app-app-icons.jpg"
            )

        )
    }

    fun getCollections(): List<Collection> {
        return listOf<Collection>(
            Collection(
                "Trending", apps = getApplications2()
            ),
            Collection("Popular Apps", apps = getApplications3()),
            Collection("Finance", apps = getApplications2())

        )
    }

    fun getRewards(): List<AppDetails> {
        return listOf<AppDetails>(
            AppDetails(
                "Netflix",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_da815BOhFqY6HAK7-9xWwxhVMAPQzCsGsw&usqp=CAU"
            ),
            AppDetails(
                "MX Player",
                "https://filmfare.wwmindia.com/content/2019/nov/indian-web-series-flames-111574763112.jpg"
            ),
            AppDetails(
                "Amazon Prime",
                "https://im.indiatimes.in/content/2021/Sep/241448122_226907436060727_3612715713474855933_n_613c58ca5e864.jpg?w=725&h=906"
            )

        )
    }

}