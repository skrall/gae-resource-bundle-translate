package org.krall.translate.service;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class TranslationService {

    private static final Logger log = LoggerFactory.getLogger(TranslationService.class);

    public OutputStream translateZipFile(InputStream is) {
        ZipInputStream zis = null;
        OutputStream os = null;
        ZipEntry entry;
        try {
            zis = new ZipInputStream(is);
            while ((entry = zis.getNextEntry()) != null) {
                log.info("Zip Entry: " + entry.getName());
                if (entry.getName().endsWith(".properties")) {
                    byte[] fileContents = IOUtils.toByteArray(zis);
                    translateTextFile(IOUtils.toInputStream(fileContents.toString()));
                }
            }
        } catch (Exception e) {
            log.error("Error while translating file.", e);
        } finally {
            IOUtils.closeQuietly(zis);
        }
        return os;
    }

    public OutputStream translateTextFile(InputStream is) {

        return null;
    }

}

