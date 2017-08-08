package th.or.nectec

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs
import com.sun.org.apache.xpath.internal.operations.Bool

/**
 * How To Parameter
 * https://thumbor.readthedocs.io/en/latest/filters.html
 */
class ThumbolClient {

    //http://localhost:8000/unsafe/trim/fit-in/500x500/filters:blur(7,0):brightness(10)/1.jpg




    var timeout :Int = 5000
    var readTimeout :Int = 9000

    var default_width :Int = 500
    var default_height :Int = 500

    var background_color: String? = null

    var blur: Int = 0
    var blur_sigma: Int = 0
    
    var brightness: Int = 0
    var contrast: Int = 0

    var equalize: Boolean = false

    var format: String? = null

    var grayscale: Boolean = false

    var max_bytes: Long? = null

    var no_upscale: Boolean = false

    var noise: Int = 0
    var quality: Int? = null
    var red_eye: Boolean = false

    var rAmount: Int = 0
    var gAmount: Int = 0
    var bAmount: Int = 0

    var rotate: Int = 0

    var strip_icc: Boolean = false



    val testurl: String = "http://localhost:8000/unsafe/trim/fit-in/500x500/filters:blur(7):brightness(40)/1.jpg"


    constructor()

    fun getImage(part_file: String) {
    }

    fun getImage(filter: String, part_file: String) {

    }


    private fun download(urlpart: String): ByteArray? {

        var data: ByteArray? = null

        testurl.httpGet().timeout(timeout).timeoutRead(readTimeout).response { request, response, result ->
            if (response.httpStatusCode == 200) {
                data = result.get()
            }
        }
        return data
    }


    companion object {
        //@JvmField val SQUARE_METRE_PER_RAI = 1600

    }
}



/*

timeout	Long	5000
readTimeout	Long	9000

default_width	Int	500
default_height	Int	500

background_color	String?	null

blur	Int	0
blur_sigma	Int	0
brightness	Int	0
contrast	Int	0

equalize	Boolean	false

format	String?	null

grayscale	Boolean	false

max_bytes	Long?	null

no_upscale	Boolean	false

noise	Int	0
quality	Int?	null
red_eye	Boolean	false

rAmount	Int	0
gAmount	Int	0
bAmount	Int	0

rotate	Int	0

strip_icc	Boolean	false

 */