/**
 *  Copyright 2005-2016 Red Hat, Inc.
 *
 *  Red Hat licenses this file to you under the Apache License, version
 *  2.0 (the "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 *  implied.  See the License for the specific language governing
 *  permissions and limitations under the License.
 */
package smmtapp.smmtapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class HomeController {

	List<MIISchJob> listMIISchJobs = new ArrayList<MIISchJob>();
	
	@GetMapping
    public String index() {
      return "redirect:/login";
    }
	
	
	@GetMapping("/login")
	  public String loginForm(Model model) {
	    model.addAttribute("login", new Login());
	    return "login";
	  }

	
	  @PostMapping("/login")
	  public String loginSubmit(@ModelAttribute Login login) {
		  
		  String StrURL = "http://"+login.getIp()+":"+login.getPort()+"/XMII/Illuminator?service=scheduler&mode=List&content-type=text/xml&IllumLoginName=" + login.getUser() + "&IllumLoginPassword=" + login.getPassword();
		  
		  try {
			login.setStringURL(StrURL+" MII Response 1 "+ new GetMIIResponse().executeGETService(StrURL));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  return "welcome";
	  }
	  
	    public String getMIISchJob(Model model) {
	        model.addAttribute("miischjobs", listMIISchJobs);
	        
	        return "display";
	    }
	 
	  
	  @PostConstruct
	    public void init() throws Exception {
		  listMIISchJobs.add(new MIISchJob("1009", "CleanupBufferedMessages","MessageRoutingFramework/MessageProcessor/BLS/BLS_CleanMessages.trx","000000***"));
	    
	    }
	  
	  

	   
}
