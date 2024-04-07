package backend.project4.moonlight_confession.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import backend.project4.moonlight_confession.domain.Recipient;
import backend.project4.moonlight_confession.domain.RecipientRepository;
import backend.project4.moonlight_confession.domain.RelationshipRepository;

@Controller
public class RecipientController {
     // Inject the RecipientRepository
     @Autowired
     private RecipientRepository recipientRepository;

     @Autowired
	private RelationshipRepository relationshipRepository; 

    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
    //show all recipients
   @RequestMapping(value= "/recipientlist")
    public String recipientList(Model model) {
        model.addAttribute("recipientlist", recipientRepository.findAll());
        return "recipientlist";
    }

    // RESTful service to get all recipients
    @RequestMapping(value="/recipients", method = RequestMethod.GET)
    public @ResponseBody List<Recipient> recipientListRest() {	
        return (List<Recipient>) recipientRepository.findAll();
    }    

	// RESTful service to get recipient by id
    @RequestMapping(value="/recipient/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Recipient> findRecipientRest(@PathVariable("id") Long recipientId) {	
    	return recipientRepository.findById(recipientId);
    }       

    //Add new recipient
    @RequestMapping(value = "/addrecipient")
    public String addRecipient(Model model) {
        model.addAttribute("recipient", new Recipient());
        model.addAttribute("relationship", relationshipRepository.findAll());
        return "addrecipient";
    }
    
    //Save new recipient
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Recipient recipient) {
        recipientRepository.save(recipient);
        return "redirect:recipientlist"; 
    }

    //Delete recipient
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteRecipient(@PathVariable("id") Long recipientId, Model model) {
        recipientRepository.deleteById(recipientId);
        return "redirect:../recipientlist"; 
    }

    // Edit book
@SuppressWarnings("null")
@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
public String editRecipient(@PathVariable("id") Long recipientId, Model model) {
model.addAttribute("recipient", recipientRepository.findById(recipientId));
model.addAttribute("relationship", relationshipRepository.findAll());
    return "editrecipient";
}

}
