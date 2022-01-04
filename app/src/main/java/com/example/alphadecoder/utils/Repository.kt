package com.example.alphadecoder.utils

import android.content.Context
import com.example.alphadecoder.AppDetails
import com.example.alphadecoder.AssistantAction
import com.example.alphadecoder.Collection
import com.example.alphadecoder.R

object Repository {

    fun getAssistantMessage(context: Context): ArrayList<AssistantAction> {
        return arrayListOf<AssistantAction>(
            AssistantAction(
                message = context.getString(R.string.hello_i_am_your_assistant),
                type = 1
            ),
            AssistantAction(message = context.getString(R.string.need_help), type = 1),
            AssistantAction(message = context.getString(R.string.i_can_help), type = 1),
            AssistantAction(
                type = 2, "",
                listOf<String>(
                    context.getString(R.string.app_search),
                    context.getString(R.string.category_search),
                    context.getString(R.string.open_app),
                    context.getString(R.string.uninstall_app),
                    context.getString(R.string.change_language),
                    context.getString(R.string.great_offers),
                    context.getString(R.string.pay_bills),
                    context.getString(R.string.clean_space),
                    context.getString(R.string.rewards_query)
                ),
            )/*,
            AssistantAction(message = "Show me Amazon Prime" , type = 0),
            AssistantAction(type = 3 , message = "" , appDetails = AppDetails(
                "Amazon Prime",
                "https://im.indiatimes.in/content/2021/Sep/241448122_226907436060727_3612715713474855933_n_613c58ca5e864.jpg?w=725&h=906"
            ), collection = Collection("" , getApplications3()) ),
            AssistantAction(message = "Show me Trending Apps" , type = 0),
            AssistantAction(type = 4 , "" , collection = Collection(
                "Trending", apps = getApplications2()
            ))*/
        )
    }

    fun getNoFoundMessage(): AssistantAction {
        return AssistantAction(
            type = 1,
            message = "Sorry, I couldn't find anything that matches your search"
        )
    }

    fun getCleanSpaceMessage(): ArrayList<AssistantAction> {
        return arrayListOf(
            AssistantAction(
                type = 1,
                message = "Here are some apps that are not frequently used"
            ),
            AssistantAction(
                type = 4, "", collection = Collection(
                    "Unused Apps",
                    apps = getApplications2() + getApplications2() + getApplications3()
                )
            )
        )
    }

    fun getFashionApps(): ArrayList<AssistantAction> {
        return arrayListOf(
            AssistantAction(
                type = 1,
                message = "Here are some apps that can help :)"
            ),
            AssistantAction(
                type = 4, "", collection = Collection(
                    "Fashion",
                    apps = getApplications2() + getApplications2() + getApplications3()
                )
            )
        )
    }

    fun getRacingGames(): ArrayList<AssistantAction> {
        return arrayListOf(
            AssistantAction(
                type = 1,
                message = "Here are some apps that match your search"
            ),
            AssistantAction(
                type = 4, "", collection = Collection(
                    "Racing Games",
                    apps = getApplications2() + getApplications2() + getApplications3()
                )
            )
        )
    }

    fun getAssistantMessage2(context: Context): ArrayList<AssistantAction> {
        return arrayListOf<AssistantAction>(
            AssistantAction(message = "Show me Amazon Prime", type = 0),
            AssistantAction(
                type = 3, message = "", appDetails = AppDetails(
                    "Amazon Prime",
                    "https://im.indiatimes.in/content/2021/Sep/241448122_226907436060727_3612715713474855933_n_613c58ca5e864.jpg?w=725&h=906"
                ),
                collection = Collection(
                    "",
                    getApplications3() + getApplications2() + getApplications()
                )
            ),
            AssistantAction(message = context.getString(R.string.show_racing_games), type = 0),
            AssistantAction(
                type = 4, "", collection = Collection(
                    context.getString(R.string.racing_games),
                    apps = getApplications2() + getApplications2() + getApplications3()
                )
            )
        )
    }

    fun getMyntraRecommendation(): ArrayList<AssistantAction> {
        return arrayListOf<AssistantAction>(
            AssistantAction(type = 1, message = "Here's what i found"),
            AssistantAction(
                type = 3, message = "", appDetails = AppDetails(
                    "Myntra",
                    "https://images.news18.com/ibnlive/uploads/2021/01/1611996262_ynt.jpeg?impolicy=website&width=510&height=356"
                ), collection = Collection("", getApplications3() + getApplications())
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

    fun getApplications3(): List<AppDetails> {
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