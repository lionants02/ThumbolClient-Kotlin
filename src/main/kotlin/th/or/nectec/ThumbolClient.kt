package th.or.nectec

import com.github.kittinunf.fuel.httpGet

class ThumbolClient {

    var timeout :Int = 5000
    var readTimeout :Int = 9000


    fun download(urlpart: String): ByteArray? {

        var data: ByteArray? = null

        urlpart.httpGet().timeout(timeout).timeoutRead(readTimeout).response { request, response, result ->
            if (response.httpStatusCode == 200) {
                data = result.get()
            }
        }
        return data
    }
    fun download(thumbolurl: ThumbolURL): ByteArray? {
        return download(thumbolurl.createUrl())
    }
}