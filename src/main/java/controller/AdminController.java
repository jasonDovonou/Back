package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import model.Admin;
import model.Pic;
import repository.AdminRepository;
import util.Utils;

@RestController
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private AdminRepository repo;

	@Value("${path.photo}")
	private String path;

	@Value("${spring.jmx.default-domain}")
	private String name;

	@GetMapping(produces = "application/json")
	public ResponseEntity<List<Admin>> getAdmins() throws IOException {
		return ResponseEntity.ok(repo.findAll());
	}

	@PostMapping(value = "/logo", produces = "application/json")
	public ResponseEntity<Object> uploadLogo(@RequestParam("file") MultipartFile file)
			throws IOException {
		File convertFile = new File(path + "/" + this.name + "Logo");
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		return ResponseEntity.ok(Utils.stringToJson("response", "File is uploaded successfully"));
	}

	@PostMapping(value = "/photo", produces = "application/json")
	public ResponseEntity<Object> uploadPhoto(@RequestParam("file") MultipartFile file)
			throws IOException {
		File convertFile = new File(path + "/" + file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
		return ResponseEntity.ok(Utils.stringToJson("response", "File is uploaded successfully"));
	}

	@PostMapping(value = "/savephoto", produces = "application/json")
	public ResponseEntity<Admin> savePhoto(@RequestBody Admin admin) throws IOException {
		for (Pic pic : admin.getPics()) {
			pic.setAdmin(admin);
		}
		repo.save(admin);
		return ResponseEntity.ok(admin);
	}

	@PostMapping(value = "/deletephoto/{name}", produces = "application/json")
	public ResponseEntity<Admin> deletePhoto(@RequestBody Admin admin,
			@PathVariable("name") String name) throws IOException {
		File folder = new File(path + "/");
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
			if (name.equals(file.getName()))
				file.delete();
		}
		int indexeremove = -1;
		for (Pic pic : admin.getPics()) {
			if (pic.getPic().equals(name))
				indexeremove = admin.getPics().indexOf(pic);
		}
		if (indexeremove != -1) {
			admin.getPics().remove(indexeremove);
			for (Pic pic : admin.getPics()) {
				pic.setAdmin(admin);
			}
			repo.save(admin);
		}
		return ResponseEntity.ok(admin);
	}

	@PostMapping(value = "/delete", produces = "application/json")
	public ResponseEntity<Object> delete(@RequestBody Admin admin) throws IOException {
		File folder = new File(path + "/");
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
			for (Pic pic : admin.getPics()) {
				if (pic.getPic().equals(file.getName()))
					file.delete();
			}
		}
		repo.delete(admin);
		return ResponseEntity.ok(Utils.stringToJson("response", "Deleted"));
	}
}
