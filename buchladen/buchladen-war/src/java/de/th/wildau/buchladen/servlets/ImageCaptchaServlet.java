package de.th.wildau.buchladen.servlets;

import de.th.wildau.buchladen.services.CaptchaServiceSingleton;
import com.octo.captcha.service.CaptchaServiceException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.3
 */
public class ImageCaptchaServlet extends HttpServlet {

    /**
     * Initialisiert die Captcha Konfiguration.
     * @param servletConfig Servlet Konfiguration
     * @throws ServletException 
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        super.init(servletConfig);
    }

    /**
     * Erstellt bei GET-Anfragen ein neues Captcha vom Format JPEG.
     * @param httpServletRequest
     * @param httpServletResponse
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            // Session ID des Benutzers der Anfrage
            String captchaId = httpServletRequest.getSession().getId();
            // passend zur Session ID wird ein Captcha generiert, 
            // diese Zuordnung kann im Validator dann verglichen werden
            BufferedImage challenge = CaptchaServiceSingleton.getInstance().getImageChallengeForID(captchaId, httpServletRequest.getLocale());
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        } catch (CaptchaServiceException e) {
            httpServletResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        
        // JPEG wird geflusht
        httpServletResponse.setHeader("Cache-Control", "no-store");
        httpServletResponse.setHeader("Pragma", "no-cache");
        httpServletResponse.setDateHeader("Expires", 0);
        httpServletResponse.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
}
