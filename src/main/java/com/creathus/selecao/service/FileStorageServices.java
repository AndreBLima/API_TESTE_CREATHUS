package com.creathus.selecao.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.creathus.selecao.models.Formulario;
import com.creathus.selecao.repository.FormularioRepository;

@Service
public class FileStorageServices {
	
	@Autowired
	private FormularioRepository formularioRepository;
	
	public Formulario store(MultipartFile file) throws IOException{
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		Formulario Formulario = new Formulario(null, null, null , null, fileName, file.getContentType(), file.getBytes());
		return formularioRepository.save(Formulario);
	}
	
	public Formulario getFiles(String id) {
	return formularioRepository.findById(id).get();
	}
	public Stream<Formulario> getAllFiles() {
	    return formularioRepository.findAll().stream();
	  }
}
