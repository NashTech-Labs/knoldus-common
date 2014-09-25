/**
 * Copyright (C) Knoldus Software LLP. <http://www.knoldus.com>
 */

package util
import java.awt.image.BufferedImage
import java.io.{ FileInputStream, File }
import org.apache.pdfbox.pdmodel.{ PDDocument, PDPage }

/**
 * PDF utility object
 */
object PDFUtils {

  /**
   *  It converts a pdf file into buffered images.
   *  It fails when either file name or file path is invalid or pdf file is not in standard format.
   *
   * @param filePath : Path for the pdf file which is to be converted
   * @param fileName : Pdf file name which is to be converted
   * @return : List of buffered images
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