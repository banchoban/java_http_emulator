package org.example.http_emulator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class HttpEmulatorController {

    private static int counter = 0;

    private static final Logger controllerLog = LogManager.getLogger(HttpEmulatorController.class);


    private String processRequest(String randValue, String counterValue, String logMessage){
        String response = "";

        if(randValue != null && !randValue.equals("")){
            response += (randValue(randValue) + "\n");
        }

        if(counterValue != null && !counterValue.equals("")){
            response += (incrementCounter(counterValue) + "\n");
        }

        if(logMessage != null && !logMessage.equals("")){
            response += msgToLog(logMessage);;
        }

        if(!response.equals("")){
            return response;
        }
        else{
            return "ok";
        }
    }

    @GetMapping("/")
    public String mainPage(Model model){
        model.addAttribute("testModel", new TestModel());
        return "index";
    }

    @PostMapping(value = "/postTest")
    @ResponseBody
    public String postRequest(Model model, @ModelAttribute("testModel") TestModel testModel){
        model.addAttribute("testModel", testModel);
        return processRequest(testModel.getRandValue(), testModel.getCounterValue(), testModel.getToLog());
    }

    public String randValue(String strValue){
        Random rnd = new Random();

        String[] digitsList = strValue.split("_");
        int result = rnd.nextInt(Integer.parseInt(digitsList[0]), Integer.parseInt(digitsList[1]) + 1);

        return String.format("randValue=%d", result);
    }

    public String incrementCounter(String counterValue){

        counter += Integer.parseInt(counterValue);
        return String.format("counterValue=%d", counter);
    }

    public String msgToLog(String message){
        if(message.length() > 80){
            return "Message length exceeded 80 characters!";
        }
        else{
            controllerLog.info(message);
            return "Message recorded to log!\n";
        }
    }

}
