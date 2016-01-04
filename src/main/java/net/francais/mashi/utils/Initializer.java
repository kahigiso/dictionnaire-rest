package net.francais.mashi.utils;

import javax.annotation.PostConstruct;

import net.francais.mashi.dic.entities.Domaine;
import net.francais.mashi.dic.entities.Example;
import net.francais.mashi.dic.entities.LangueOrigine;
import net.francais.mashi.dic.entities.MotFrancais;
import net.francais.mashi.dic.entities.MotMashi;
import net.francais.mashi.dic.entities.Nature;
import net.francais.mashi.dic.entities.Role;
import net.francais.mashi.dic.entities.User;
import net.francais.mashi.dic.services.DomaineService;
import net.francais.mashi.dic.services.ExampleService;
import net.francais.mashi.dic.services.LangueOrigineService;
import net.francais.mashi.dic.services.MotFrancaisService;
import net.francais.mashi.dic.services.MotMashiService;
import net.francais.mashi.dic.services.NatureService;
import net.francais.mashi.dic.services.RoleService;
import net.francais.mashi.dic.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class Initializer {
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	@Autowired
	private NatureService natureService;
	@Autowired
	private MotFrancaisService motFrancaisService;
	@Autowired
	private MotMashiService motMashiService;
	@Autowired
	private LangueOrigineService langueOrigineService;
	@Autowired
	private ExampleService exampleService;
	@Autowired
	private DomaineService domaineService;
//	@Autowired
//	private ClassificationService classificationService;
	
	
	@PostConstruct
	public void init(){
		System.out.println("=====================Adding data======================");
		createRole();
		createUser();
		createDomaine();
		createNature();
		createLangueOrigine();
		createMotFrancais();
		createMotMashi();
		createMotExample();
		System.out.println("=====================Finish adding data================");
	}
	
	
	private void createMotExample(){
		newExample(motMashiService.findByMot("NDWALA"), "La pauvreté est une maladie.", "Obukenyi ndwala.");
		newExample(motMashiService.findByMot("CIBAGIRO"), "Elle (la vache) pense que c'est de l'amour, pourtant c'est à l'abattoir qu'on l'amène.", "Enamanye mpu busime n'obwo ecibagiro bayiheka.");
		newExample(motMashiService.findByMot("LUJUCI"), "Laisse l'abeiller manger son miel.", "Olek'olujuci lulye obuci bwalo");
	}
	
	private void createMotMashi(){
		newMotMashi("BUTULI","","", "", "",natureService.findByName("Adverbe"), null,motFrancaisService.findByMot("A L'ENVERS"));
		newMotMashi("NDWALA","","", "ENDWALA","ENDWALA", natureService.findByName("Nom commun"), null,motFrancaisService.findByMot("MALADIE"));
		newMotMashi("KURHENGA","","", "", "",natureService.findByName("Adverbe"), null,motFrancaisService.findByMot("A PARTIR DE"));
		newMotMashi("NTONDENTONDE","","", "","", natureService.findByName("Adverbe"), null,motFrancaisService.findByMot("A PETITS PAS"));
		newMotMashi("CIBAGIRO","","", "ECIBAGIRO","EBIBAGIRO", natureService.findByName("Nom commun"), null,motFrancaisService.findByMot("ABATTOIR"));
		newMotMashi("KUBAGA","","", "","", natureService.findByName("Verbe"), null,motFrancaisService.findByMotAndPrecizion("ABATTRE","_DU BETAIL"));
		newMotMashi("KUKUBA","","", "","", natureService.findByName("Verbe"), null,motFrancaisService.findByMotAndPrecizion("ABATTRE","_UN ARBRE OU UNE GRANDE CHOSE")); 
		newMotMashi("MASIRA","","", "AMASIRA","AMASIRA", natureService.findByName("Nom commun"), null,motFrancaisService.findByMot("ABCES"));
		newMotMashi("SIDA","","VIH SIDA", "ESIDA","AMASIDA", natureService.findByName("Nom commun"), langueOrigineService.findByName("FRANCAIS"),motFrancaisService.findByMot("SIDA"));
		newMotMashi("LUJUCI","","", "OLUJUCI","ENJUCI", natureService.findByName("Nom commun"), null,motFrancaisService.findByMot("ABEILLE"));
		newMotMashi("LUFABE","","ALPHABET", "OLUFABE", "AMALUFABE",natureService.findByName("Nom commun"), langueOrigineService.findByName("FRANCAIS"),motFrancaisService.findByMot("ALPHABET"));
		newMotMashi("KULUGA","","", "", "",natureService.findByName("Verbe"), null,motFrancaisService.findByMot("ABONDER"));
		newMotMashi("KUMOKA","","", "", "",natureService.findByName("Verbe"), null,motFrancaisService.findByMot("ABOYER"));
		
		
	}
	
	private void createMotFrancais(){
		newMotFrancais("A L'ENVERS","",domaineService.findByName("ADVERBE"));
		newMotFrancais("MALADIE","",domaineService.findByName("MEDECINE"));
		newMotFrancais("A PARTIR DE","",domaineService.findByName("ADVERBE"));
		newMotFrancais("A PETITS PAS","LENTEMENT",domaineService.findByName("ADVERBE"));
		newMotFrancais("ABATTOIR","",null);
		newMotFrancais("ABATTRE","_DU BETAIL",null);
		newMotFrancais("ABATTRE","_UN ARBRE OU UNE GRANDE CHOSE",domaineService.findByName("FORET"));
		newMotFrancais("ABCES","",domaineService.findByName("MEDECINE"));
		newMotFrancais("SIDA","VIH",domaineService.findByName("MEDECINE"));
		newMotFrancais("ABEILLE","",domaineService.findByName("ZOOLOGIE"));
		newMotFrancais("ALPHABET","",domaineService.findByName("GRAMMAIRE"));
		newMotFrancais("ABONDER","ÊTRE NOMBREUX",domaineService.findByName("PHYSIQUE"));
		newMotFrancais("ABOYER","",domaineService.findByName("ZOOLOGIE"));
	}

		
	private void createLangueOrigine(){
		newLangueOrigine("ANGLAIS","EN");
		newLangueOrigine("ARABE","AR");
		newLangueOrigine("FRANCAIS","FR");
		newLangueOrigine("GREC","GC");
		newLangueOrigine("HEBREU","HB");
		newLangueOrigine("KINYARWANDA","RW");
		newLangueOrigine("KIREGA","RG");
		newLangueOrigine("KIRUNDI","BU");
		newLangueOrigine("LATIN","LT");
		newLangueOrigine("SWAHILI","SW");
	}
	private void createNature(){
		newNature("Nom commun", "N");
		newNature("Verbe", "V");
		newNature("Adverbe", "ADV");
		newNature("Adjectif", "ADJ");
		newNature("Exclamation", "EXC");
		newNature("Nom propre", "NP");
		newNature("Pronom", "PR");
	}
	
	private void createDomaine(){
		newDomaine("ADJECTIF");
		newDomaine("ADVERBE");
		newDomaine("AGRICULTURE");
		newDomaine("ANATOMIE");
		newDomaine("BOTANIQUE");
		newDomaine("GRAMMAIRE");
		newDomaine("CONSTRUCTION");
		newDomaine("CUISINE");
		newDomaine("TRANSPORT");
		newDomaine("COMMERCE");
		newDomaine("EDUCATION");
		newDomaine("ELEVAGE");
		newDomaine("EXCLAMATION");
		newDomaine("FAMILLE");
		newDomaine("FORET");
		newDomaine("GEOGRAPHIE");
		newDomaine("ESPACE");
		newDomaine("HABILLEMENT");
		newDomaine("HABITATION");
		newDomaine("VACHE");
		newDomaine("JUSTICE");
		newDomaine("PHILOSOPHIE");
		newDomaine("MEDECINE");
		newDomaine("MILITAIRE");
		newDomaine("MUSIQUE");
		newDomaine("ZOOLOGIE");
		newDomaine("PHYSIQUE");
	}
	
	private void createUser(){
		 newUser("admin", "admin@gmail.com", "admin", roleService.findByName("ROLE_ADMIN"));
		 newUser("user", "user@gmail.com", "user", roleService.findByName("ROLE_USER"));
	}
	
	private void createRole(){
		 newRole("ROLE_ADMIN");
		 newRole("ROLE_MANAGER");
		 newRole("ROLE_USER");
	}
	
	
	private void newExample(MotMashi motMashi, String txtFrancais, String txtMashi){
		Example example = new Example();
		example.setMotMashi(motMashi);
		example.setTxtFrancais(txtFrancais);
		example.setTxtMashi(txtMashi);
		example.setAddedBy(userService.findByEmail("admin@gmail.com"));
		exampleService.createOrUpdate(example);
		
	}
	
	private void newMotMashi(String mot, String precision,String origine, String singulier, String pluriel, Nature nature, LangueOrigine langueOrigine, MotFrancais motFrancais){
		MotMashi motMashi = new MotMashi();
		motMashi.setMot(mot);
		motMashi.setOrigine(origine);
		motMashi.setPluriel(pluriel);
		motMashi.setSingulier(singulier);
		motMashi.setNature(nature);
		motMashi.setLangueOrigine(langueOrigine);
		motMashi.setMotFrancais(motFrancais);
		motMashi.setAddedBy(userService.findByEmail("admin@gmail.com"));
		
		motMashi = motMashiService.createOrUpdate(motMashi);
		
		motFrancais.setMotMashi(motMashi);
		motFrancaisService.createOrUpdate(motFrancais);
		nature.addMotMashi(motMashi);
		natureService.createOrUpdate(nature);
	}
	
	
	private void newMotFrancais(String mot, String precizion, Domaine domaine){
		MotFrancais motFrancais = new MotFrancais();
		motFrancais.setMot(mot);
		motFrancais.setPrecizion(precizion);
		motFrancais.setDomaine(domaine);
		motFrancais.setAddedBy(userService.findByEmail("admin@gmail.com"));
		motFrancais = motFrancaisService.createOrUpdate(motFrancais);
		if(domaine != null){
			domaine.addMotFrancais(motFrancais);
			domaineService.createOrUpdate(domaine);
		}
	}
	
	private void newLangueOrigine(String name, String abbreviation){
		LangueOrigine lOrigine = new LangueOrigine();
		lOrigine.setName(name);
		lOrigine.setAbbreviation(abbreviation);
		lOrigine.setAddedBy(userService.findByEmail("admin@gmail.com"));
		langueOrigineService.createOrUpdate(lOrigine);
	}
    private void newDomaine(String name){
    	Domaine domaine = new Domaine();
    	domaine.setName(name);
    	domaine.setAbbreviation(name);
    	domaine.setAddedBy(userService.findByEmail("admin@gmail.com"));
        domaineService.createOrUpdate(domaine);
    }
    
    private void newNature(String name, String abbreviation){
    	Nature nature = new Nature();
    	nature.setName(name);
    	nature.setAbbreviation(abbreviation);
    	nature.setAddedBy(userService.findByEmail("admin@gmail.com"));
    	natureService.createOrUpdate(nature);
    }
    
    private void newUser(String name, String email, String psswrd,  Role role){
        User user = new User();
        user.setName(name);
        user.setPassword(psswrd);
        user.setEmail(email);
        user.setActive(true);
        user.addRole(role);
        userService.createOrUpdate(user);
    }
    
    private void newRole(String name){
       Role role = new Role();
       role.setName(name);
       roleService.createOrUpdate(role); 
    }
}
