package th.or.nectec

import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs
import com.sun.org.apache.xpath.internal.operations.Bool

/**
 * How To Parameter
 * https://thumbor.readthedocs.io/en/latest/filters.html
 */
class ThumbolURL(// = "http://localhost:8000"
        var hosturl: String, //= "1.jpg"
        var imagename: String) {

    //http://localhost:8000/unsafe/trim/fit-in/500x500/filters:blur(7,0):brightness(10)/1.jpg

    var hmac_keyAUTH: String? = null

    var background_color: String? = null

    var blur: Int = 0
    var blur_sigma: Int = 0

    var brightness: Int = 0
    var contrast: Int = 0

    var equalize: Boolean = false

    var format: String? = null

    var grayscale: Boolean = false


    var rAmount: Int = 0
    var gAmount: Int = 0
    var bAmount: Int = 0

    var rotate: Int = 0

    var strip_icc: Boolean = false


    var max_bytes: Long? = null

    var no_upscale: Boolean = false

    var noise: Int = 0
    var quality: Int? = null
    var red_eye: Boolean = false

    fun getUrl(): String {
        var genurl = hosturl
        genurl += hmac_keyAUTHFilter()
        genurl += addFilter()
        genurl += addFilename()


        return genurl
    }

    private fun addFilter(): String {
        var filter = "/filters"
        filter += background_colorFilter()

        filter += blurFilter()

        filter += brightnessFilter()
        filter += contrastFilter()

        filter += equalizeFilter()

        filter += formatFilter()

        filter += grayscaleFilter()

        filter += max_bytesFilter()

        filter += no_upscaleFilter()

        filter += noiseFilter()
        filter += qualityFilter()
        filter += red_eyeFilter()

        filter += rgbAmountFilter()

        filter += rotateFilter()

        filter += strip_iccFilter()
        return if (!filter.endsWith("/filters")) filter else ""
    }


    /*
     private fun $1Filter\(\) {
          genurl+=if\($1!=null\) { $1.toString\(\) }else ""
      }
  
    
     */
    /*private fun checkAddFilter(): String {
        return if (!genurl.contains("/filters")) "/filters" else ""
    }*/

    private fun hmac_keyAUTHFilter(): String {
        return if (hmac_keyAUTH != null) {
            "/" + hmac_keyAUTH.toString()
        } else "/unsafe"
    }


    private fun background_colorFilter(): String {
        return if (background_color != null) {
            ":background_color(" + background_color.toString() + ")"
        } else ""
    }


    private fun blurFilter(): String {
        return if (blur != 0) {
            ":blur(" + blur.toString() + "," + blur_sigma.toString() + ")"
        } else ""
    }


    private fun brightnessFilter(): String {
        return if (brightness != 0) {
            ":brightness(" + brightness.toString() + ")"
        } else ""
    }

    private fun contrastFilter(): String {
        return if (contrast != 0) {
            ":contrast(" + contrast.toString() + ")"
        } else ""
    }

    private fun equalizeFilter(): String {
        return if (equalize) {
            ":equalize()"
        } else ""
    }


    private fun formatFilter(): String {
        return if (format != null) {
            ":format(" + format.toString() + ")"
        } else ""
    }

    private fun grayscaleFilter(): String {
        return if (grayscale) {
            ":grayscale()"
        } else ""
    }

    private fun rgbAmountFilter(): String {
        return if ((rAmount or gAmount or bAmount) != 0) {
            ":rgb(" + rAmount.toString() + "," + gAmount.toString() + "," + bAmount.toString() + ")"
        } else ""
    }


    private fun rotateFilter(): String {
        return if (rotate != 0) {
            ":rotate(" + rotate.toString() + ")"
        } else ""
    }

    /////////////////////////////////---------------
    private fun max_bytesFilter(): String {
        return if (max_bytes != null) {
            "/" + max_bytes.toString()
        } else ""
    }


    private fun no_upscaleFilter(): String {
        return if (no_upscale) {
            "/" + no_upscale.toString()
        } else ""
    }


    private fun noiseFilter(): String {
        return if (noise != 0) {
            "/" + noise.toString()
        } else ""
    }

    private fun qualityFilter(): String {
        return if (quality != null) {
            "/" + quality.toString()
        } else ""
    }

    private fun red_eyeFilter(): String {
        return if (red_eye) {
            "/" + red_eye.toString()
        } else ""
    }


    private fun strip_iccFilter(): String {
        return if (strip_icc) {
            "/" + strip_icc.toString()
        } else ""
    }


    private fun addFilename(): String {
        return "/" + imagename
    }


}


/*
    hmac_keyAUTH	String?	null

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


