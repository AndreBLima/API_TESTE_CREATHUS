package com.creathus.selecao.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.creathus.selecao.form.PessoaForms;
import com.creathus.selecao.message.ResponseFile;
import com.creathus.selecao.message.ResponseMessage;
import com.creathus.selecao.models.Formulario;
import com.creathus.selecao.repository.FormularioRepository;
import com.creathus.selecao.service.FileStorageServices;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")

public class FormularioResources {

	@Autowired
	FormularioRepository formularioRepository;

	@GetMapping("/formulario")
	public List<Formulario> listaPessoas(){
		return formularioRepository.findAll();
	}

	@GetMapping("/pessoa/{id}")
	public Formulario pessoa(@PathVariable(value="id") long id){
		return formularioRepository.findById(id);
	}

	@PostMapping("/formulario")
	public Formulario SalvaPessoa(@RequestBody @Valid PessoaForms pessoa){
		Formulario formulario= pessoa.converter();
		return formularioRepository.save(formulario);

	}

	@DeleteMapping("/formulario")
	public void deletaPessoa(@RequestBody Formulario pessoa) {
		formularioRepository.delete(pessoa);
	}

	@PutMapping("/formulario")
	public Formulario AtualizaPessoa(@RequestBody @Valid PessoaForms pessoa) {
		Formulario formulario = pessoa.converter();
		return formularioRepository.save(formulario);
	}
	
	
	// inicio foto
	private FileStorageServices storageService;
	
	@PostMapping("/upload")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
	    String message = "";
	    try {
	      storageService.store(file);

	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }
		
	@GetMapping("/files")
	  public ResponseEntity<List<ResponseFile>> getListFiles() {
	    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
	      String fileDownloadUri = ServletUriComponentsBuilder
	          .fromCurrentContextPath()
	          .path("/files/")
	          .path(dbFile.getId())
	          .toUriString();

	      return new ResponseFile(
	          dbFile.getNome(),
	          fileDownloadUri,
	          dbFile.getTipo_arquivo(),
	          dbFile.getData().length);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(files);
	  }
	
	@GetMapping("/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
		  Formulario formulario = storageService.getFiles(id);

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + formulario.getNome_arquivo() + "\"")
	        .body(formulario.getData());
	  }
	
	// fim foto

}
