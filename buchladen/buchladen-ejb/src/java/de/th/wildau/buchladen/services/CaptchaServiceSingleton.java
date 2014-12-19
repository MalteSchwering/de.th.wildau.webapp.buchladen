package de.th.wildau.buchladen.services;

import com.octo.captcha.service.image.ImageCaptchaService;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;

/**
 * @author Jan Gabler
 * @author Malte Schwering
 * @version 0.1
 */
public class CaptchaServiceSingleton {

    /**
     * Eine neue Instanz des Captcha-Services.
     */
    private static ImageCaptchaService instance = new DefaultManageableImageCaptchaService();

    /**
     * Liefert die Instanz des Captcha-Services zurück.
     * @return Instanz des Captcha-Services
     */
    public static ImageCaptchaService getInstance() {
        return instance;
    }
}
