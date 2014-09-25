/**
 * Copyright (C) Knoldus Software LLP. <http://www.knoldus.com>
 */

package util
import java.awt.image.BufferedImage
import java.io.{ FileInputStream, File }
import org.apache.pdfbox.pdmodel.{ PDDocument, PDPage }

/**
 *
 */
object PDFUtils {

  /**
   *
   */
  def convertPdfToBufferedImage(filePath: String, fileName: String): Either[String, List[BufferedImage]] = {

    try {
      val file = new File(filePath, fileName)

      if (file.isFile()) {
        val doc = PDDocument.load(new FileInputStream(file));
        val pages = doc.getDocumentCatalog().getAllPages()

        val listOfBufferedImage = for (i <- 0 until pages.size()) yield {
          val page = pages.get(i)
          val image = page.asInstanceOf[PDPage].convertToImage()
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