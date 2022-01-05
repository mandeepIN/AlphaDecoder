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
                    context.getString(R.string.change_language),
                    context.getString(R.string.search),
                    context.getString(R.string.explore),
                    context.getString(R.string.clean_phone),
                    context.getString(R.string.rewards_query)
                ),
            )
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
                message = "Okay, Here are some apps that you haven't used lately"
            ),
            AssistantAction(
                type = 4, "", collection = Collection(
                    "",
                    apps = getUnusedApps()
                )
            )
        )
    }

    private fun getUnusedApps(): List<AppDetails> {
        return listOf<AppDetails>(
            AppDetails(
                "PUBG",
                "https://play-lh.googleusercontent.com/IWzNaEFTy_AMUoHBTNCqCUGv6mwZhz-ZeXeu8yYBQFYjB98A4RylaL2I4masrZvTwA=s180-rw",
                "870 MB"
            ),
            AppDetails(
                "Facebook",
                "https://play-lh.googleusercontent.com/ccWDU4A7fX1R24v-vvT480ySh26AYp97g1VrIB_FIdjRcuQB2JP2WdY7h_wVVAeSpg=s180-rw",
                "120 MB"
            ),
            AppDetails(
                "Meesho",
                "https://upload.wikimedia.org/wikipedia/commons/8/80/Meesho_Logo_Full.png",
                "40 MB"
            ),
            AppDetails(
                "Snapchat",
                "https://play-lh.googleusercontent.com/KxeSAjPTKliCErbivNiXrd6cTwfbqUJcbSRPe_IBVK_YmwckfMRS1VIHz-5cgT09yMo=s180-rw",
                "56 MB"
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

    fun startDownload(): ArrayList<AssistantAction> {
        return arrayListOf(
            AssistantAction(type = 1, message = "Okay, Downloading Myntra on your device"),
            AssistantAction(type = 1, message = "Finished downloading your app"),
            AssistantAction(type = 1, message = "Do you want to open the app ?"),
            )
    }

    fun getRacingGames(): ArrayList<AssistantAction> {
        return arrayListOf(
            AssistantAction(
                type = 1,
                message = "Here are the top gaming apps for you"
            ),
            AssistantAction(
                type = 4, "", collection = Collection(
                    "Racing Games",
                    apps = getApplications2() + getApplications2() + getApplications3()
                )
            )
        )
    }

    fun getTopGaming(): ArrayList<AssistantAction> {
        return arrayListOf(
            AssistantAction(
                type = 1,
                message = "Here are the top gaming apps for you"
            ),
            AssistantAction(
                type = 4, "", collection = Collection(
                    "",
                    apps = getTopGamingApps()
                )
            )
        )
    }

    fun getCategorySuggestions(context: Context): ArrayList<AssistantAction> {
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

    fun getTopAppsMessage(): ArrayList<AssistantAction> {
        return arrayListOf(
            AssistantAction(
                type = 1,
                message = "Here are the top apps of 2021 for you"
            ),
            AssistantAction(
                type = 4, "", collection = Collection(
                    "",
                    apps = getTopApps()
                )
            )
        )
    }

    private fun getTopApps(): ArrayList<AppDetails> {
        return arrayListOf(
            AppDetails(
                "Whatsapp",
                "https://play-lh.googleusercontent.com/bYtqbOcTYOlgc6gqZ2rwb8lptHuwlNE75zYJu6Bn076-hTmvd96HH-6v7S0YUAAJXoJN=s180-rw"
            ),
            AppDetails(
                "Instagram",
                "https://play-lh.googleusercontent.com/h9jWMwqb-h9hjP4THqrJ50eIwPekjv7QPmTpA85gFQ10PjV02CoGAcYLLptqd19Sa1iJ=s180-rw"
            ),
            AppDetails(
                "Snapchat",
                "https://play-lh.googleusercontent.com/KxeSAjPTKliCErbivNiXrd6cTwfbqUJcbSRPe_IBVK_YmwckfMRS1VIHz-5cgT09yMo=s180-rw"
            ),
            AppDetails(
                "Facebook",
                "https://play-lh.googleusercontent.com/ccWDU4A7fX1R24v-vvT480ySh26AYp97g1VrIB_FIdjRcuQB2JP2WdY7h_wVVAeSpg=s180-rw"
            )
        )
    }

    fun getAssistantMessage2(context: Context): ArrayList<AssistantAction> {
        return arrayListOf<AssistantAction>(
            AssistantAction(message = "Show me Amazon Prime", type = 0),
            AssistantAction(
                type = 3, message = "", appDetails = AppDetails(
                    "Amazon",
                    "https://mondrian.mashable.com/uploads%252Fcard%252Fimage%252F1603703%252F270775c5-1af8-4bce-9641-80fd513922cc.webp%252Ffull-fit-in__950x534.webp?signature=BXPPZTz0ARDqvEiDZ7MS3GAepNw=&source=https%3A%2F%2Fblueprint-api-production.s3.amazonaws.com"
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
            AssistantAction(type = 1, message = "Okay, Here are the results for you"),
            AssistantAction(
                type = 3, message = "", appDetails = AppDetails(
                    "Myntra",
                    "https://play-lh.googleusercontent.com/wpnNPYIrdHC3Q_bcFXGpwoMvFvvvQnZJHmFKzumq5ZTRZKIzfxURAUGOMqhPhVxnggY=s180-rw"
                ), collection = Collection("", getMyntraSimilar())
            )
        )
    }

    fun getMyntraSimilar(): ArrayList<AppDetails> {
        return arrayListOf(
            AppDetails(
                "Tata CLiQ",
                "https://play-lh.googleusercontent.com/YYMB0q3VZuH1cegb-s636R6p4cIPivJ-4BMn04ogVWfw1l0JrJSFYZ2xvcjsPEWY5ro=s180-rw"
            ),
            AppDetails(
                "Meesho",
                "https://upload.wikimedia.org/wikipedia/commons/8/80/Meesho_Logo_Full.png"
            ),
            AppDetails(
                "Nykaa",
                "https://play-lh.googleusercontent.com/_ExrvmW1leB8u5hck_OGDNCrgh408W7PzlASH_OdZhzWfb4L2vAcY-1N-qUwnOT8BcE=s180-rw"
            ),
            AppDetails(
                "Amazon Shopping",
                "https://play-lh.googleusercontent.com/QPKtPRTJyhrYoPqYmjP81aCeYAQrH7ocIC25Tw8spEoKsX7eY0cqXMJp4QfkIq2bSg=s180-rw"
            )
        )
    }

    private fun getTopGamingApps(): ArrayList<AppDetails> {
        return arrayListOf(
            AppDetails(
                "PUBG: NEW STATE",
                "https://play-lh.googleusercontent.com/IWzNaEFTy_AMUoHBTNCqCUGv6mwZhz-ZeXeu8yYBQFYjB98A4RylaL2I4masrZvTwA=s180-rw"
            ),
            AppDetails(
                "Ludo King",
                "https://play-lh.googleusercontent.com/1h5Nk52vWS7JyI_EqFBOJkFCC0JhsJYnbUGZYxOSqKXuFfKm9UNMaEVZ4XrmZ-HjiQ=s180-rw"
            ),
            AppDetails(
                "Fruit Ninja",
                "https://play-lh.googleusercontent.com/eJ9OJnbRer1jjg5ZeNAnTXKcGd2B_NEqxCp2UsefcCABeFBaj_pNl_WKYBjup2GVGGc=s180-rw"
            ),
            AppDetails(
                "Candy Crush Saga",
                "https://play-lh.googleusercontent.com/TLUeelx8wcpEzf3hoqeLxPs3ai1tdGtAZTIFkNqy3gbDp1NPpNFTOzSFJDvZ9narFS0=s180-rw"
            )
        )
    }

    fun getApplications(): List<AppDetails> {
        return listOf<AppDetails>(
            AppDetails(
                "Paytm -UPI, Money Transfer, Recharge, Bill Payment",
                "https://pixlok.com/wp-content/uploads/2021/02/Paytm-Cricle-Logo-PNG.jpg"
            ),
            AppDetails(
                "MX Player",
                "data:image/png;base64,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"
            ),
            AppDetails(
                "Amazon",
                "https://mondrian.mashable.com/uploads%252Fcard%252Fimage%252F1603703%252F270775c5-1af8-4bce-9641-80fd513922cc.webp%252Ffull-fit-in__950x534.webp?signature=BXPPZTz0ARDqvEiDZ7MS3GAepNw=&source=https%3A%2F%2Fblueprint-api-production.s3.amazonaws.com"
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
                "Amazon",
                "https://i.pinimg.com/736x/bd/c7/c3/bdc7c3cff06903a0d36db0fe5d4fd5c4--logo-app-app-icons.jpg"
            )

        )
    }

    fun getApplications3(): List<AppDetails> {
        return listOf<AppDetails>(
            AppDetails(
                "Moj Lite",
                "https://user-images.githubusercontent.com/72242474/100070379-e1343d00-2e5f-11eb-90f0-cf360238f2a6.jpeg"
            ),
            AppDetails(
                "CoinSwitch",
                "https://play-lh.googleusercontent.com/ug82MxfgWE3v3kaHsLaaY8oDrreSrUaLkT39Xht01_MYGrXnnmDQGmnQFWs-8hMa0A"
            ),
            AppDetails(
                "Forest",
                "https://www.forestapp.cc/img/icon.png"
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