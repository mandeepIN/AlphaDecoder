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

    fun getCategorySuggestions(context: Context) : ArrayList<AssistantAction>{
        return arrayListOf<AssistantAction>(
            AssistantAction(message = context.getString(R.string.category_suggestion), type = 1),
            AssistantAction(
                type = 2, "",
                listOf<String>(
                    context.getString(R.string.cat_shopping),
                    context.getString(R.string.cat_finance),
                    context.getString(R.string.cat_games),
                    context.getString(R.string.cat_music)
                ),
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

    fun getGamingApps(context: Context): ArrayList<AssistantAction> {
        return arrayListOf(
            AssistantAction(
                type = 1,
                message = "Here are some apps that match your search"
            ),
            AssistantAction(
                type = 4, "", collection = Collection(
                    "Games",
                    apps = getGamingAppList()
                )
            )
        )
    }

    fun getGamingAppList():List<AppDetails>{
        return listOf<AppDetails>(
            AppDetails(
                "Ludo King™",
                "https://cdnimages-api.appbazaar.com/preview_images/icon_34d4c37f-184c-4bb9-8f6e-a575744e4bbc.webp"
            ),
            AppDetails(
                "RummyCircle - Play 13 Card Indian Rummy",
                "https://cdnimages-api.appbazaar.com/preview_images/e65876b6c64d9f74ae8e68a986770242.webp"
            ),
            AppDetails(
                "Temple Run 2",
                "https://cdnimages-api.appbazaar.com/preview_images/icon_24e138d8-59f6-4683-87c8-dae7142c6cea.webp"
            ),
            AppDetails(
                "Subway Surfers",
                "https://cdnimages-api.appbazaar.com/preview_images/icon_dc6b2f22-4994-4d76-a226-fdfad6cf225b.webp"
            ),
            AppDetails(
                "Candy Crush Saga",
                "https://cdnimages-api.appbazaar.com/preview_images/icon_6fe9a3d2-c3c8-483f-8164-0d537e3a28da.webp"
            ),
            AppDetails(
                "Real Gangster Crime",
                "https://cdnimages-api.appbazaar.com/preview_images/icon_dafd8ee7-531a-40b4-b94b-7bd8d4e57697.webp"
            )
        )
    }
    fun getMusicApps(context: Context): ArrayList<AssistantAction> {
        return arrayListOf(
            AssistantAction(
                type = 1,
                message = "Here are some apps that match your search"
            ),
            AssistantAction(
                type = 4, "", collection = Collection(
                    "Music",
                    apps = getMusicAppList()
                )
            )
        )
    }

    fun getMusicAppList():List<AppDetails>{
        return listOf<AppDetails>(
            AppDetails(
                "Vidmate",
                "https://cdnimages-api.appbazaar.com/preview_images/7f7eaa3098a4a9f9ca9167343bb33e7f.webp"
            ),
            AppDetails(
                "Amazon Music: Discover Songs",
                "https://cdnimages-api.appbazaar.com/preview_images/icon_7a7f06f1-abc8-41bc-a23a-8d3c6306b10d.webp"
            ),
            AppDetails(
                "Spotify: Music and Podcasts",
                "https://cdnimages-api.appbazaar.com/preview_images/icon_e308202f-2966-4e80-9be2-f19d5b335f5d.webp"
            ),
            AppDetails(
                "Wynk Music- New Songs, Offline Music & Podcast App",
                "https://cdnimages-api.appbazaar.com/preview_images/icon_4400353a-9bee-44e8-96fa-776ae4994ddd.webp"
            ),
            AppDetails(
                "Music Player",
                "https://cdnimages-api.appbazaar.com/preview_images/icon_03325864-d782-4146-bddc-8d548133ab75.webp"
            )
        )
    }
    fun getFinanceApps(context: Context): ArrayList<AssistantAction> {
        return arrayListOf(
            AssistantAction(
                type = 1,
                message = "Here are some apps that match your search"
            ),
            AssistantAction(
                type = 4, "", collection = Collection(
                    "Finance",
                    apps = getFinanceAppList()
                )
            )
        )
    }


    fun getFinanceAppList():List<AppDetails>{
        return listOf<AppDetails>(
            AppDetails(
                "ETMONEY: Mutual Funds, SIP, Portfolio Tracking App",
                "https://cdnimages-api.appbazaar.com/preview_images/icon_0371c9a8-7f5d-4d2e-b466-9330289bc297.webp"
            ),
            AppDetails(
                "PhonePe: UPI, Recharge, Investment, Insurance",
                "https://cdnimages-api.appbazaar.com/preview_images/icon_c14d66e6-9f3a-4cb1-b71a-f8f4a660243c.webp"
            ),
            AppDetails(
                "HDFC Bank Mobile App",
                "https://cdnimages-api.appbazaar.com/preview_images/d404d3b113adf8da606838e107c55274.webp"
            ),
            AppDetails(
                "HDFC Life Insurance App",
                "https://cdnimages-api.appbazaar.com/preview_images/icon_27ada5e5-a016-4c3f-a003-786ce83ee152.webp"
            ),
            AppDetails(
                "Bajaj Finserv-Loan,UPI,Payment",
                "https://cdnimages-api.appbazaar.com/preview_images/icon_7bdab812-2cfe-4fb4-9cad-c94c74f4944b.webp"
            )
        )
    }

    fun getShoppingApps(context: Context): ArrayList<AssistantAction> {
        return arrayListOf(
            AssistantAction(
                type = 1,
                message = "Here are some apps that match your search"
            ),
            AssistantAction(
                type = 4, "", collection = Collection(
                    "Shopping",
                    apps = getShoppingAppList()
                )
            )
        )
    }


    fun getShoppingAppList():List<AppDetails>{
        return listOf<AppDetails>(
            AppDetails(
                "Amazon India - Shop & Pay",
                "https://cdnimages-api.appbazaar.com/preview_images/icon_f5bb3e18-9d85-4c68-a80f-7916764d3230.webp"
            ),
            AppDetails(
                "Myntra Online Shopping App",
                "https://cdnimages-api.appbazaar.com/preview_images/icon_61abc321-df73-4865-b9c6-11a1455e3006.webp"
            ),
            AppDetails(
                "Flipkart Online Shopping App",
                "https://cdnimages-api.appbazaar.com/preview_images/icon_100615f5-2db2-49d8-a3d2-53f725eb1b9b.webp"
            ),
            AppDetails(
                "Tata CLiQ Online Shopping App India",
                "https://cdnimages-api.appbazaar.com/preview_images/icon_069e99b4-b776-4456-b128-9578bd8b3f87.webp"
            ),
            AppDetails(
                "Snapdeal: Online Shopping App",
                "https://cdnimages-api.appbazaar.com/preview_images/icon_e54523a3-9eca-4fcf-bba5-c9c9dd55557e.webp"
            )
        )
    }

}