/**
 * Copyright (C) Knoldus Software LLP. <http://www.knoldus.com>
 */

package util

import java.awt.image.BufferedImage
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.pdmodel.PDPage
import java.io.File
import java.io.FileInputStream
import java.awt.geom.Rectangle2D
import java.awt.RenderingHints
import java.awt.Color
import org.apache.poi.hslf.usermodel.SlideShow

/**
 * PPT utility object
 *
 * @author Rishi Khandelwal
 */
object PPTUtils {

  /**
   *  It converts a .ppt file into buffered images.
   *  It fails when either file name or file path is invalid or .ppt file is not in standard format.
   *
   * @param filePath : Path for the .ppt file which is to be converted
   * @param fileName : PPT file name which is to be converted
   * @return : List of buffered images
   */
  def convertPptToBufferedImage(filePath: String, fileName: String): Either[String, List[BufferedImage]] = {

    try {
      val file = new File(filePath, fileName)

      if (file.isFile()) {

        val inputStream = new FileInputStream(file)
        val ppt = new SlideShow(inputStream)
        inputStream.close()

        val pagegSize = ppt.getPageSize()

        val slide = ppt.getSlides();
        
        val listOfBufferedImage = for (i <- 0 until slide.length) yield {
          
          val image = new BufferedImage(pagegSize.width, pagegSize.height, 1)
          val graphics = image.createGraphics()
          graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
          graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY)
          graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BICUBIC)
          graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS,
            RenderingHints.VALUE_FRACTIONALMETRICS_ON)
          graphics.setColor(Color.white)
          graphics.clearRect(0, 0, pagegSize.width, pagegSize.height)
          graphics.fill(new Rectangle2D.Float(0, 0, pagegSize.width, pagegSize.height))

          // render
          slide(i).draw(graphics)
          image
        }
        Right(listOfBufferedImage.toList)
      } else {
        Left("File does not exisit")
      }
    } catch {
      case ex: Exception =>
        Left("There is error in file reading")
    }
  }

}