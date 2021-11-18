package com.ftn.CAFOOD.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ftn.CAFOOD.model.Image;
import com.ftn.CAFOOD.repository.ImageRepository;


@Service
public class ImageService {

	@Autowired
	ImageRepository ir;
	
	public void save( MultipartFile file ) throws IOException {
		
//		final Optional<Image> retrievedImage = ir.findOneByName(file.getOriginalFilename());
//		if(retrievedImage.isEmpty()) {
//			System.out.println("AJDEEE OVDE");
//			Image img = new Image(compressBytes(file.getBytes()), file.getOriginalFilename(),true);
//			ir.saveAndFlush(img);
//		}
		
		try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            Image fileDB = new Image(file.getBytes(), fileName, true);
            ir.save(fileDB);
           
        } catch (Exception e) {
           
        }
	}

	public Image findById(Long id) {

        return ir.findById(id).orElse(null);
    }
    
    public Image findByName(String name) {

        return ir.findOneByName(name).orElse(null);
    }
	
	
//	public Image getImage(String imageName) throws IOException {
//		final Optional<Image> retrievedImage = ir.findOneByName(imageName);
//		Image img = new Image(decompressBytes(retrievedImage.get().getContent()) , retrievedImage.get().getName(),true);
//		return img;
//	}
//
//	// compress the image bytes before storing it in the database
//	public static byte[] compressBytes(byte[] data) {
//		Deflater deflater = new Deflater();
//		deflater.setInput(data);
//		deflater.finish();
//		
//		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//		byte[] buffer = new byte[1024];
//		while (!deflater.finished()) {
//			int count = deflater.deflate(buffer);
//			outputStream.write(buffer, 0, count);
//		}
//		try {
//			outputStream.close();
//		} catch (IOException e) {
//		}
//		return outputStream.toByteArray();
//	}
//
//	// uncompress the image bytes before returning it to the angular application
//	public static byte[] decompressBytes(byte[] data) {
//		Inflater inflater = new Inflater();
//		inflater.setInput(data);
//		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
//		byte[] buffer = new byte[1024];
//		try {
//			while (!inflater.finished()) {
//				int count = inflater.inflate(buffer);
//				outputStream.write(buffer, 0, count);
//			}
//			outputStream.close();
//		} catch (IOException ioe) {
//		} catch (DataFormatException e) {
//		}
//		return outputStream.toByteArray();
//	}
	
}
