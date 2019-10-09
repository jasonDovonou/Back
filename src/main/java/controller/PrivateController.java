package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import model.Article;
import model.Lot;
import model.article.Black;
import model.article.Blue;
import model.article.Brown;
import model.article.Gold;
import model.article.Green;
import model.article.Grey;
import model.article.News;
import model.article.Orange;
import model.article.Promotion;
import model.article.Purple;
import model.article.Red;
import model.article.White;
import model.article.Yellow;
import model.lot.BlackLot;
import model.lot.BlueLot;
import model.lot.BrownLot;
import model.lot.GoldLot;
import model.lot.GreenLot;
import model.lot.GreyLot;
import model.lot.OrangeLot;
import model.lot.PurpleLot;
import model.lot.RedLot;
import model.lot.WhiteLot;
import model.lot.YellowLot;
import repository.OrderRepo;
import repository.article.BlackRepo;
import repository.article.BlueRepo;
import repository.article.BrownRepo;
import repository.article.GoldRepo;
import repository.article.GreenRepo;
import repository.article.GreyRepo;
import repository.article.NewsRepo;
import repository.article.OrangeRepo;
import repository.article.PromotionRepo;
import repository.article.PurpleRepo;
import repository.article.RedRepo;
import repository.article.WhiteRepo;
import repository.article.YellowRepo;
import util.Utils;

@RestController
@RequestMapping("/")
public class PrivateController {

	@Value("${path.photo}")
	private String path;

	@Autowired
	WhiteRepo white;

	@Autowired
	GreyRepo grey;

	@Autowired
	BlueRepo blue;

	@Autowired
	RedRepo red;

	@Autowired
	BlackRepo black;

	@Autowired
	OrderRepo order;

	@Autowired
	OrangeRepo orange;

	@Autowired
	BrownRepo brown;

	@Autowired
	YellowRepo yellow;

	@Autowired
	GreenRepo green;

	@Autowired
	PurpleRepo purple;

	@Autowired
	GoldRepo gold;

	@Autowired
	PromotionRepo promotion;

	@Autowired
	NewsRepo news;

	@GetMapping(value = "white", produces = "application/json")
	public ResponseEntity<List<White>> getWhites() throws IOException {
		return ResponseEntity.ok(white.findAll());
	}

	@GetMapping(value = "white/{name}", produces = "application/json")
	public ResponseEntity<White> getWhite(@PathVariable("name") String name) throws IOException {
		return ResponseEntity.ok(white.findByName(name));
	}

	@DeleteMapping(value = "white/photos/{name}", produces = "application/json")
	public ResponseEntity<Object> whiteDeletePhoto(@PathVariable("name") String name)
			throws IOException {
		deletePhoto("white", name);
		return ResponseEntity.ok(Utils.stringToJson("response", "Photo deleted"));
	}

	@PostMapping(value = "white/delete", produces = "application/json")
	public ResponseEntity<Object> deleteWhite(@RequestBody White white) throws IOException {
		deletePhoto("white", Arrays.asList(white.getPhoto().split("[;]+")));
		this.white.deleteByName(white.getName());
		deleteNewsPromo(white.getName());
		return ResponseEntity.ok(Utils.stringToJson("response", "Article deleted"));
	}

	@PostMapping(value = "white/upload", produces = "application/json")
	public ResponseEntity<Object> whiteUploadPhoto(@RequestParam("file") MultipartFile file,
			@RequestParam String name) throws IOException {
		uploadPhoto("white", file, name);
		return ResponseEntity.ok(Utils.stringToJson("response", "File is uploaded successfully"));
	}

	@PostMapping(value = "white/save", produces = "application/json")
	public ResponseEntity<Object> saveWhite(@RequestBody White white) throws IOException {
		List<Lot> lots = new ArrayList<>();
		for (WhiteLot lot : white.getLots()) {
			lot.setWhite(white);
			lots.add(lot);
		}
		this.white.save(white);
		this.saveNewsPromo(white.getName(), white, lots);
		return ResponseEntity.ok(Utils.stringToJson("response", "Article saved"));
	}

	@GetMapping(value = "yellow", produces = "application/json")
	public ResponseEntity<List<Yellow>> getYellows() throws IOException {
		return ResponseEntity.ok(yellow.findAll());
	}

	@GetMapping(value = "yellow/{name}", produces = "application/json")
	public ResponseEntity<Yellow> getYellow(@PathVariable("name") String name) throws IOException {
		return ResponseEntity.ok(yellow.findByName(name));
	}

	@DeleteMapping(value = "yellow/photos/{name}", produces = "application/json")
	public ResponseEntity<Object> yellowDeletePhoto(@PathVariable("name") String name)
			throws IOException {
		deletePhoto("yellow", name);
		deleteNewsPromo(name);
		return ResponseEntity.ok(Utils.stringToJson("response", "Photo deleted"));
	}

	@PostMapping(value = "yellow/delete", produces = "application/json")
	public ResponseEntity<Object> deleteYellow(@RequestBody Yellow yellow) throws IOException {
		deletePhoto("yellow", Arrays.asList(yellow.getPhoto().split("[;]+")));
		this.yellow.deleteByName(yellow.getName());
		deleteNewsPromo(yellow.getName());
		return ResponseEntity.ok(Utils.stringToJson("response", "Article deleted"));
	}

	@PostMapping(value = "yellow/upload", produces = "application/json")
	public ResponseEntity<Object> yellowUploadPhoto(@RequestParam("file") MultipartFile file,
			@RequestParam String name) throws IOException {
		uploadPhoto("yellow", file, name);
		return ResponseEntity.ok(Utils.stringToJson("response", "File is uploaded successfully"));
	}

	@PostMapping(value = "yellow/save", produces = "application/json")
	public ResponseEntity<Object> saveYellow(@RequestBody Yellow yellow) throws IOException {

		List<Lot> lots = new ArrayList<>();
		for (YellowLot lot : yellow.getLots()) {
			lot.setYellow(yellow);
			lots.add(lot);
		}
		this.yellow.save(yellow);
		this.saveNewsPromo(yellow.getName(), yellow, lots);
		return ResponseEntity.ok(Utils.stringToJson("response", "Article saved"));
	}

	@GetMapping(value = "gold", produces = "application/json")
	public ResponseEntity<List<Gold>> getGolds() throws IOException {
		return ResponseEntity.ok(gold.findAll());
	}

	@GetMapping(value = "gold/{name}", produces = "application/json")
	public ResponseEntity<Gold> getGold(@PathVariable("name") String name) throws IOException {
		return ResponseEntity.ok(gold.findByName(name));
	}

	@DeleteMapping(value = "gold/photos/{name}", produces = "application/json")
	public ResponseEntity<Object> goldDeletePhoto(@PathVariable("name") String name)
			throws IOException {
		deletePhoto("gold", name);
		deleteNewsPromo(name);
		return ResponseEntity.ok(Utils.stringToJson("response", "Photo deleted"));
	}

	@PostMapping(value = "gold/delete", produces = "application/json")
	public ResponseEntity<Object> deleteGold(@RequestBody Gold gold) throws IOException {
		deletePhoto("gold", Arrays.asList(gold.getPhoto().split("[;]+")));
		this.gold.deleteByName(gold.getName());
		deleteNewsPromo(gold.getName());
		return ResponseEntity.ok(Utils.stringToJson("response", "Article deleted"));
	}

	@PostMapping(value = "gold/upload", produces = "application/json")
	public ResponseEntity<Object> goldUploadPhoto(@RequestParam("file") MultipartFile file,
			@RequestParam String name) throws IOException {
		uploadPhoto("gold", file, name);
		return ResponseEntity.ok(Utils.stringToJson("response", "File is uploaded successfully"));
	}

	@PostMapping(value = "gold/save", produces = "application/json")
	public ResponseEntity<Object> saveGold(@RequestBody Gold gold) throws IOException {

		List<Lot> lots = new ArrayList<>();
		for (GoldLot lot : gold.getLots()) {
			lot.setGold(gold);
			lots.add(lot);
		}
		this.gold.save(gold);
		this.saveNewsPromo(gold.getName(), gold, lots);
		return ResponseEntity.ok(Utils.stringToJson("response", "Article saved"));
	}

	@GetMapping(value = "purple", produces = "application/json")
	public ResponseEntity<List<Purple>> getPurples() throws IOException {
		return ResponseEntity.ok(purple.findAll());
	}

	@GetMapping(value = "purple/{name}", produces = "application/json")
	public ResponseEntity<Purple> getPurple(@PathVariable("name") String name) throws IOException {
		return ResponseEntity.ok(purple.findByName(name));
	}

	@DeleteMapping(value = "purple/photos/{name}", produces = "application/json")
	public ResponseEntity<Object> purpleDeletePhoto(@PathVariable("name") String name)
			throws IOException {
		deletePhoto("purple", name);
		return ResponseEntity.ok(Utils.stringToJson("response", "Photo deleted"));
	}

	@PostMapping(value = "purple/delete", produces = "application/json")
	public ResponseEntity<Object> deletePurple(@RequestBody Purple purple) throws IOException {
		deletePhoto("purple", Arrays.asList(purple.getPhoto().split("[;]+")));
		this.purple.deleteByName(purple.getName());
		deleteNewsPromo(purple.getName());
		return ResponseEntity.ok(Utils.stringToJson("response", "Article deleted"));
	}

	@PostMapping(value = "purple/upload", produces = "application/json")
	public ResponseEntity<Object> purpleUploadPhoto(@RequestParam("file") MultipartFile file,
			@RequestParam String name) throws IOException {
		uploadPhoto("purple", file, name);
		return ResponseEntity.ok(Utils.stringToJson("response", "File is uploaded successfully"));
	}

	@PostMapping(value = "purple/save", produces = "application/json")
	public ResponseEntity<Object> savePurple(@RequestBody Purple purple) throws IOException {
		List<Lot> lots = new ArrayList<>();
		for (PurpleLot lot : purple.getLots()) {
			lot.setPurple(purple);
			lots.add(lot);
		}
		this.purple.save(purple);
		this.saveNewsPromo(purple.getName(), purple, lots);
		return ResponseEntity.ok(Utils.stringToJson("response", "Article saved"));
	}

	@GetMapping(value = "grey", produces = "application/json")
	public ResponseEntity<List<Grey>> getGreys() throws IOException {
		return ResponseEntity.ok(grey.findAll());
	}

	@GetMapping(value = "grey/{name}", produces = "application/json")
	public ResponseEntity<Grey> getGrey(@PathVariable("name") String name) throws IOException {
		return ResponseEntity.ok(grey.findByName(name));
	}

	@DeleteMapping(value = "grey/photos/{name}", produces = "application/json")
	public ResponseEntity<Object> greyDeletePhoto(@PathVariable("name") String name)
			throws IOException {
		deletePhoto("grey", name);
		return ResponseEntity.ok(Utils.stringToJson("response", "Photo deleted"));
	}

	@PostMapping(value = "grey/delete", produces = "application/json")
	public ResponseEntity<Object> deleteGrey(@RequestBody Grey grey) throws IOException {
		deletePhoto("grey", Arrays.asList(grey.getPhoto().split("[;]+")));
		this.grey.deleteByName(grey.getName());
		deleteNewsPromo(grey.getName());
		return ResponseEntity.ok(Utils.stringToJson("response", "Article deleted"));
	}

	@PostMapping(value = "grey/upload", produces = "application/json")
	public ResponseEntity<Object> greyUploadPhoto(@RequestParam("file") MultipartFile file,
			@RequestParam String name) throws IOException {
		uploadPhoto("grey", file, name);
		return ResponseEntity.ok(Utils.stringToJson("response", "File is uploaded successfully"));
	}

	@PostMapping(value = "grey/save", produces = "application/json")
	public ResponseEntity<Object> saveGrey(@RequestBody Grey grey) throws IOException {
		List<Lot> lots = new ArrayList<>();
		for (GreyLot lot : grey.getLots()) {
			lot.setGrey(grey);
			lots.add(lot);
		}
		this.grey.save(grey);
		this.saveNewsPromo(grey.getName(), grey, lots);
		return ResponseEntity.ok(Utils.stringToJson("response", "Article saved"));
	}

	@GetMapping(value = "blue", produces = "application/json")
	public ResponseEntity<List<Blue>> getBlues() throws IOException {
		return ResponseEntity.ok(blue.findAll());
	}

	@GetMapping(value = "blue/{name}", produces = "application/json")
	public ResponseEntity<Blue> getBlue(@PathVariable("name") String name) throws IOException {
		return ResponseEntity.ok(blue.findByName(name));
	}

	@DeleteMapping(value = "blue/photos/{name}", produces = "application/json")
	public ResponseEntity<Object> blueDeletePhoto(@PathVariable("name") String name)
			throws IOException {
		deletePhoto("blue", name);
		return ResponseEntity.ok(Utils.stringToJson("response", "Photo deleted"));
	}

	@PostMapping(value = "blue/delete", produces = "application/json")
	public ResponseEntity<Object> deleteBlue(@RequestBody Blue blue) throws IOException {
		deletePhoto("blue", Arrays.asList(blue.getPhoto().split("[;]+")));
		this.blue.deleteByName(blue.getName());
		deleteNewsPromo(blue.getName());
		return ResponseEntity.ok(Utils.stringToJson("response", "Article deleted"));
	}

	@PostMapping(value = "blue/upload", produces = "application/json")
	public ResponseEntity<Object> blueUploadPhoto(@RequestParam("file") MultipartFile file,
			@RequestParam String name) throws IOException {
		uploadPhoto("blue", file, name);
		return ResponseEntity.ok(Utils.stringToJson("response", "File is uploaded successfully"));
	}

	@PostMapping(value = "blue/save", produces = "application/json")
	public ResponseEntity<Object> saveBlue(@RequestBody Blue blue) throws IOException {
		List<Lot> lots = new ArrayList<>();
		for (BlueLot lot : blue.getLots()) {
			lot.setBlue(blue);
			lots.add(lot);
		}
		this.blue.save(blue);
		this.saveNewsPromo(blue.getName(), blue, lots);
		return ResponseEntity.ok(Utils.stringToJson("response", "Article saved"));
	}

	@GetMapping(value = "green", produces = "application/json")
	public ResponseEntity<List<Green>> getGreens() throws IOException {
		return ResponseEntity.ok(green.findAll());
	}

	@GetMapping(value = "green/{name}", produces = "application/json")
	public ResponseEntity<Green> getGreen(@PathVariable("name") String name) throws IOException {
		return ResponseEntity.ok(green.findByName(name));
	}

	@DeleteMapping(value = "green/photos/{name}", produces = "application/json")
	public ResponseEntity<Object> greenDeletePhoto(@PathVariable("name") String name)
			throws IOException {
		deletePhoto("green", name);
		return ResponseEntity.ok(Utils.stringToJson("response", "Photo deleted"));
	}

	@PostMapping(value = "green/delete", produces = "application/json")
	public ResponseEntity<Object> deleteGreen(@RequestBody Green green) throws IOException {
		deletePhoto("green", Arrays.asList(green.getPhoto().split("[;]+")));
		this.green.deleteByName(green.getName());
		deleteNewsPromo(green.getName());
		return ResponseEntity.ok(Utils.stringToJson("response", "Article deleted"));
	}

	@PostMapping(value = "green/upload", produces = "application/json")
	public ResponseEntity<Object> greenUploadPhoto(@RequestParam("file") MultipartFile file,
			@RequestParam String name) throws IOException {
		uploadPhoto("green", file, name);
		return ResponseEntity.ok(Utils.stringToJson("response", "File is uploaded successfully"));
	}

	@PostMapping(value = "green/save", produces = "application/json")
	public ResponseEntity<Object> saveGreen(@RequestBody Green green) throws IOException {
		List<Lot> lots = new ArrayList<>();
		for (GreenLot lot : green.getLots()) {
			lot.setGreen(green);
			lots.add(lot);
		}
		this.green.save(green);
		this.saveNewsPromo(green.getName(), green, lots);
		return ResponseEntity.ok(Utils.stringToJson("response", "Article saved"));
	}

	@GetMapping(value = "brown", produces = "application/json")
	public ResponseEntity<List<Brown>> getBrowns() throws IOException {
		return ResponseEntity.ok(brown.findAll());
	}

	@GetMapping(value = "brown/{name}", produces = "application/json")
	public ResponseEntity<Brown> getBrown(@PathVariable("name") String name) throws IOException {
		return ResponseEntity.ok(brown.findByName(name));
	}

	@DeleteMapping(value = "brown/photos/{name}", produces = "application/json")
	public ResponseEntity<Object> brownDeletePhoto(@PathVariable("name") String name)
			throws IOException {
		deletePhoto("brown", name);
		return ResponseEntity.ok(Utils.stringToJson("response", "Photo deleted"));
	}

	@PostMapping(value = "brown/delete", produces = "application/json")
	public ResponseEntity<Object> deleteBrown(@RequestBody Brown brown) throws IOException {
		deletePhoto("brown", Arrays.asList(brown.getPhoto().split("[;]+")));
		this.brown.deleteByName(brown.getName());
		deleteNewsPromo(brown.getName());
		return ResponseEntity.ok(Utils.stringToJson("response", "Article deleted"));
	}

	@PostMapping(value = "brown/upload", produces = "application/json")
	public ResponseEntity<Object> brownUploadPhoto(@RequestParam("file") MultipartFile file,
			@RequestParam String name) throws IOException {
		uploadPhoto("brown", file, name);
		return ResponseEntity.ok(Utils.stringToJson("response", "File is uploaded successfully"));
	}

	@PostMapping(value = "brown/save", produces = "application/json")
	public ResponseEntity<Object> saveBrown(@RequestBody Brown brown) throws IOException {
		List<Lot> lots = new ArrayList<>();
		for (BrownLot lot : brown.getLots()) {
			lot.setBrown(brown);
			lots.add(lot);
		}
		this.brown.save(brown);
		this.saveNewsPromo(brown.getName(), brown, lots);
		return ResponseEntity.ok(Utils.stringToJson("response", "Article saved"));
	}

	@GetMapping(value = "red", produces = "application/json")
	public ResponseEntity<List<Red>> getReds() throws IOException {
		return ResponseEntity.ok(red.findAll());
	}

	@GetMapping(value = "red/{name}", produces = "application/json")
	public ResponseEntity<Red> getRed(@PathVariable("name") String name) throws IOException {
		return ResponseEntity.ok(red.findByName(name));
	}

	@DeleteMapping(value = "red/photos/{name}", produces = "application/json")
	public ResponseEntity<Object> redDeletePhoto(@PathVariable("name") String name)
			throws IOException {
		deletePhoto("red", name);
		return ResponseEntity.ok(Utils.stringToJson("response", "Photo deleted"));
	}

	@PostMapping(value = "red/delete", produces = "application/json")
	public ResponseEntity<Object> deleteRed(@RequestBody Red red) throws IOException {
		deletePhoto("red", Arrays.asList(red.getPhoto().split("[;]+")));
		this.red.deleteByName(red.getName());
		deleteNewsPromo(red.getName());
		return ResponseEntity.ok(Utils.stringToJson("response", "Article deleted"));
	}

	@PostMapping(value = "red/upload", produces = "application/json")
	public ResponseEntity<Object> redUploadPhoto(@RequestParam("file") MultipartFile file,
			@RequestParam String name) throws IOException {
		uploadPhoto("red", file, name);
		return ResponseEntity.ok(Utils.stringToJson("response", "File is uploaded successfully"));
	}

	@PostMapping(value = "red/save", produces = "application/json")
	public ResponseEntity<Object> saveRed(@RequestBody Red red) throws IOException {
		List<Lot> lots = new ArrayList<>();
		for (RedLot lot : red.getLots()) {
			lot.setRed(red);
			lots.add(lot);
		}
		this.red.save(red);
		this.saveNewsPromo(red.getName(), red, lots);
		return ResponseEntity.ok(Utils.stringToJson("response", "Article saved"));
	}

	@GetMapping(value = "black", produces = "application/json")
	public ResponseEntity<List<Black>> getBlacks() throws IOException {
		return ResponseEntity.ok(black.findAll());
	}

	@GetMapping(value = "black/{name}", produces = "application/json")
	public ResponseEntity<Black> getBlack(@PathVariable("name") String name) throws IOException {
		return ResponseEntity.ok(black.findByName(name));
	}

	@DeleteMapping(value = "black/photos/{name}", produces = "application/json")
	public ResponseEntity<Object> blackDeletePhoto(@PathVariable("name") String name)
			throws IOException {
		deletePhoto("black", name);
		return ResponseEntity.ok(Utils.stringToJson("response", "Photo deleted"));
	}

	@PostMapping(value = "black/delete", produces = "application/json")
	public ResponseEntity<Object> deleteBlack(@RequestBody Black black) throws IOException {
		deletePhoto("black", Arrays.asList(black.getPhoto().split("[;]+")));
		this.black.deleteByName(black.getName());
		deleteNewsPromo(black.getName());
		return ResponseEntity.ok(Utils.stringToJson("response", "Article deleted"));
	}

	@PostMapping(value = "black/upload", produces = "application/json")
	public ResponseEntity<Object> blackUploadPhoto(@RequestParam("file") MultipartFile file,
			@RequestParam String name) throws IOException {
		uploadPhoto("black", file, name);
		return ResponseEntity.ok(Utils.stringToJson("response", "File is uploaded successfully"));
	}

	@PostMapping(value = "black/save", produces = "application/json")
	public ResponseEntity<Object> saveBlack(@RequestBody Black black) throws IOException {
		List<Lot> lots = new ArrayList<>();
		for (BlackLot lot : black.getLots()) {
			lot.setBlack(black);
			lots.add(lot);
		}
		this.black.save(black);
		this.saveNewsPromo(black.getName(), black, lots);
		return ResponseEntity.ok(Utils.stringToJson("response", "Article saved"));
	}

	@GetMapping(value = "orange", produces = "application/json")
	public ResponseEntity<List<Orange>> getOranges() throws IOException {
		return ResponseEntity.ok(orange.findAll());
	}

	@GetMapping(value = "orange/{name}", produces = "application/json")
	public ResponseEntity<Orange> getOrange(@PathVariable("name") String name) throws IOException {
		return ResponseEntity.ok(orange.findByName(name));
	}

	@DeleteMapping(value = "orange/photos/{name}", produces = "application/json")
	public ResponseEntity<Object> orangeDeletePhoto(@PathVariable("name") String name)
			throws IOException {
		deletePhoto("orange", name);
		return ResponseEntity.ok(Utils.stringToJson("response", "Photo deleted"));
	}

	@PostMapping(value = "orange/delete", produces = "application/json")
	public ResponseEntity<Object> deleteOrange(@RequestBody Orange orange) throws IOException {
		deletePhoto("orange", Arrays.asList(orange.getPhoto().split("[;]+")));
		this.orange.deleteByName(orange.getName());
		deleteNewsPromo(orange.getName());
		return ResponseEntity.ok(Utils.stringToJson("response", "Article deleted"));
	}

	@PostMapping(value = "orange/upload", produces = "application/json")
	public ResponseEntity<Object> orangeUploadPhoto(@RequestParam("file") MultipartFile file,
			@RequestParam String name) throws IOException {
		uploadPhoto("orange", file, name);
		return ResponseEntity.ok(Utils.stringToJson("response", "File is uploaded successfully"));
	}

	@PostMapping(value = "orange/save", produces = "application/json")
	public ResponseEntity<Object> saveOrange(@RequestBody Orange orange) throws IOException {
		List<Lot> lots = new ArrayList<>();
		for (OrangeLot lot : orange.getLots()) {
			lot.setOrange(orange);
			lots.add(lot);
		}
		this.orange.save(orange);
		this.saveNewsPromo(orange.getName(), orange, lots);
		return ResponseEntity.ok(Utils.stringToJson("response", "Article saved"));
	}

	@GetMapping(value = "promotion", produces = "application/json")
	public ResponseEntity<List<Promotion>> getPromotions() throws IOException {
		return ResponseEntity.ok(promotion.findAll());
	}

	@GetMapping(value = "promotion/{name}", produces = "application/json")
	public ResponseEntity<Promotion> getPromotion(@PathVariable("name") String name)
			throws IOException {
		return ResponseEntity.ok(promotion.findByName(name));
	}

	@GetMapping(value = "news", produces = "application/json")
	public ResponseEntity<List<News>> getNewss() throws IOException {
		return ResponseEntity.ok(news.findAll());
	}

	@GetMapping(value = "news/{name}", produces = "application/json")
	public ResponseEntity<News> getNews(@PathVariable("name") String name) throws IOException {
		return ResponseEntity.ok(news.findByName(name));
	}

	void deletePhoto(String type, String name) throws IOException {
		File folder = new File(path + "/" + type);
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
			if (name.equals(file.getName()))
				file.delete();
		}
	}

	void deletePhoto(String type, List<String> names) throws IOException {
		File folder = new File(path + "/" + type);
		File[] listOfFiles = folder.listFiles();
		for (String photo : names) {
			for (File file : listOfFiles) {
				if (photo.equals(file.getName()))
					file.delete();
			}
		}
	}

	void uploadPhoto(String type, MultipartFile file, String name) throws IOException {
		File convertFile = new File(
				path + "/" + type + "/" + name + "_" + file.getOriginalFilename());
		convertFile.createNewFile();
		FileOutputStream fout = new FileOutputStream(convertFile);
		fout.write(file.getBytes());
		fout.close();
	}

	void saveNewsPromo(String name, Article article, List<Lot> lots) {
		Promotion promo = promotion.findByName(name);
		News news = this.news.findByName(name);
		if (promo != null) {
			if (article.getPromo() == 0)
				promotion.deleteByName(name);
			else
				promotion.save(new Promotion(name, article, lots));
		} else if (article.getPromo() != 0) {
			promotion.save(new Promotion(name, article, lots));
		}

		if (news != null) {
			if (!article.isNews())
				this.news.deleteByName(name);
			else
				this.news.save(new News(name, article, lots));
		} else if (article.isNews()) {
			this.news.save(new News(name, article, lots));
		}
	}

	void deleteNewsPromo(String name) {
		promotion.deleteByName(name);
		this.news.deleteByName(name);

	}

}