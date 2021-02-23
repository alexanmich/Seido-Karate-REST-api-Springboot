package seidokarate.kata;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import seidokarate.kata.Kata.Grade;

@Controller
public class KataController {
	private final ArrayList<Kata> white = new ArrayList<Kata>();
	private final ArrayList<Kata> blue = new ArrayList<Kata>();
	private final ArrayList<Kata> yellow = new ArrayList<Kata>();
	private final ArrayList<Kata> green = new ArrayList<Kata>();
	private final ArrayList<Kata> brown = new ArrayList<Kata>();
	private final ArrayList<Kata> all = new ArrayList<Kata>();
	
	/***
	 * Constructer, calls helper method to load
	 * all grade arraylists.
	 */
	public KataController() {
		loadArrays();
	}
	
	/***
	 * Landing page endpoint
	 * 
	 * @return home page template
	 */
	@GetMapping("/")
	public String home() {
		return "index.html";
	}
	
	/***
	 * GET request for all katas.
	 * 
	 * @return ArrayList<Kata>
	 */
	@GetMapping("/all")
	public String listSyllabus(Model model) {
        model.addAttribute("katas", all);
        return "AllTemplate.html";
	}
	
	/***
	 * GET request for all katas 
	 * of the given grade.
	 * 
	 * @param grade
	 * @return ArrayList<Kata> for given grade
	 */
	@GetMapping("/all/{grade}")
	public String listSyllabusByGrade(@PathVariable("grade") String grade, Model model) {
		switch(grade) {
		case "white":
			model.addAttribute("katas", white);
			break;
		case "blue":
			model.addAttribute("katas", blue);
			break;
		case "yellow":
			model.addAttribute("katas", yellow);
			break;
		case "green":
			model.addAttribute("katas", green);
			break;
		case "brown":
			model.addAttribute("katas", brown);
			break;
		default:
			model.addAttribute("katas", all);
		}
		return "AllTemplate.html";
	}
	
	/***
	 * GET request for a random kata
	 * 
	 * @return random kata
	 */
	@GetMapping("/random")
	public String randomSyllabus(Model model) {
		Kata kata = all.get(new Random().nextInt(all.size()));
		model.addAttribute("kata", kata);
		return "RandomTemplate.html";
	}
	
	/***
	 * GET request for a random kata
	 * for a given grade.
	 * 
	 * @param grade
	 * @return random kata for a given grade
	 */
	@GetMapping("/random/{grade}")
	public String randomSyllabus(@PathVariable("grade") String grade, Model model) {
		Kata kata;
		switch(grade) {
		case "white":
			kata = white.get(new Random().nextInt(white.size()));
			break;
		case "blue":
			kata = blue.get(new Random().nextInt(blue.size()));
			break;
		case "yellow":
			kata = yellow.get(new Random().nextInt(yellow.size()));
			break;
		case "green":
			kata = green.get(new Random().nextInt(green.size()));
			break;
		case "brown":
			kata = brown.get(new Random().nextInt(brown.size()));
			break;
		default:
			kata = all.get(new Random().nextInt(all.size()));
			
		}
		model.addAttribute("kata", kata);
		return "RandomTemplate.html";
	}
	
	/***
	 * Loads all arraylists for each grade
	 * with the relevant katas. 
	 */
	public void loadArrays() {
		this.white.add(new Kata("Taikyoku Sono Ichi", Grade.WHITE));
		this.white.add(new Kata("Taikyoku Sono Ni", Grade.WHITE));
		this.white.add(new Kata("Taikyoku Sono San", Grade.WHITE));
		this.blue.add(new Kata("Pinan Sono Ichi", Grade.BLUE));
		this.blue.add(new Kata("Seido Sono Ichi", Grade.BLUE));
		this.yellow.add(new Kata("Pinan Sono Ni", Grade.YELLOW));
		this.yellow.add(new Kata("Pinan Sono San", Grade.YELLOW));
		this.yellow.add(new Kata("Seido Sono Ni", Grade.YELLOW));
		this.yellow.add(new Kata("Sanchin Kata", Grade.YELLOW));
		this.green.add(new Kata("Pinan Sono Yon", Grade.GREEN));
		this.green.add(new Kata("Seido Sono San", Grade.GREEN));
		this.green.add(new Kata("Gekisai-Dai Kata", Grade.GREEN));
		this.green.add(new Kata("Yansu Kata", Grade.GREEN));
		this.brown.add(new Kata("Pinan Sono Go", Grade.BROWN));
		this.brown.add(new Kata("Seido Sono Yon", Grade.BROWN));
		this.brown.add(new Kata("Skina Kata", Grade.BROWN));
		this.brown.add(new Kata("Saiha Kata", Grade.BROWN));
		this.brown.add(new Kata("Tensho Kata", Grade.BROWN));
		this.all.addAll(white);
		this.all.addAll(blue);
		this.all.addAll(yellow);
		this.all.addAll(green);
		this.all.addAll(brown);
	}
}
