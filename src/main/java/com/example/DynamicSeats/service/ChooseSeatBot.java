package com.example.DynamicSeats.service;

import com.example.DynamicSeats.constnats.TwilioParams;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChooseSeatBot implements CommandLineRunner {

    private final WriteMessage writeMessageService;
    private final BussinessService bussinessService;
//    @Autowired
//    private final table1Repository table1Repository;

    @Override
    public void run(String... args) throws Exception {
        writeMessageService.writeMessage("Hello " +
                 bussinessService.getEmployeeName(TwilioParams.PHONE_NUMBER) +
                " \uD83E\uDDD1\u200D\uD83D\uDCBC" + "\nFrom Department " +    bussinessService.getEmployeeDepartment(TwilioParams.PHONE_NUMBER) +
                ",\nWelcome to the seats choose bot \n" +
                "Please Choose on which Floor do you want to seat today? \uD83D\uDCBA" +
                "\n1️⃣ - Quiet floor \n2️⃣ - Open space \n3️⃣ - Cubical \n");

        Message lastMessage = null;
        ZonedDateTime currentZonedDateTime = ZonedDateTime.now();

        Integer selectedFloor=1;
        String selectedArea="A";
        // Continuously fetch and print new messages
        while (true) {
            ResourceSet<Message> messages = Message.reader()
                    .setTo(TwilioParams.WHATSAPP_NUMBER)
                    .setDateSentAfter(currentZonedDateTime)
                    .read();

            // Get the latest message if there are any new messages
            List<Message> messageList = new ArrayList<>();
            for (Message msg : messages) {
                messageList.add(msg);
            }
            if (!messageList.isEmpty()) {
                Message latestMessage = messageList.get(0);

                // If the latest message is different from the last message,
                // print the message and send Response
                if (lastMessage==null || !latestMessage.getBody().equals(lastMessage.getBody())) {
                    log.info(latestMessage.getBody());
                    switch (latestMessage.getBody()) {
                        case "1":

                        case "2":

                        case "3":
                            selectedFloor= Integer.valueOf(latestMessage.getBody());
                            writeMessageService.writeMessage("Please choose Favorite area in Floor-" + latestMessage.getBody().trim()
                                    + ": \n▫️A\n▫️B\n▫️C\n▫️D");
                            break;
                        case "A":
                        case "B":
                        case "C":
                        case "D":
                            selectedArea= latestMessage.getBody();
                            writeMessageService.writeMessage("The available seats in floor number: "+ selectedFloor+" and area: "+selectedArea+" are:"+
                                    //\nSeat a1\nSeat b3\nSeat c7" +
                                    "\nSeats " + bussinessService.getTop3Seats(selectedFloor,selectedArea) +

//  "\n\n"+ "‼️Please choose the seat you want ...");
                                    "\n\n"+ "‼️Please type the seat you want including the word \"Seat\" at the    beginning");
                            break;
                        default:
                            if (latestMessage.getBody().contains("Seat")) {
                                String seatNumber="";
                                seatNumber=latestMessage.getBody().substring(5);
                                writeMessageService.writeMessage(seatNumber + " was Occupied Successfully," +
                                        "\nIt will be yours until the end of the day, \nHave a nice day. \uD83C\uDF3B");
                            } else {
                                writeMessageService.writeMessage("Not Available option, Please try again");
                            }
                            break;
                    }
                    lastMessage = latestMessage;
                    currentZonedDateTime = ZonedDateTime.now();
                }
            }
            // Wait before checking for new messages again
            try {
                Thread.sleep(TwilioParams.DELAY_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

