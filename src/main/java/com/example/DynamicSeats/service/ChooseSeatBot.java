package com.example.DynamicSeats.service;

import com.example.DynamicSeats.constnats.TwilioConsts;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChooseSeatBot implements CommandLineRunner {

    private final WriteMessage writeMessageService;

    @Override
    public void run(String... args) throws Exception {
        writeMessageService.writeMessage("Hello " + TwilioConsts.WHATSAPP_USER_NAME + " \uD83E\uDDD1\u200D\uD83D\uDCBC" + "\nFrom Department הפצת מידע ללקוחות" +
                ",\nWelcome to the seats choose bot \n" +
                "Please Choose on which Floor do you want to seat today? \uD83D\uDCBA" +
                "\n1️⃣ \n2️⃣ \n3️⃣");

        Message lastMessage = null;
        ZonedDateTime currentZonedDateTime = ZonedDateTime.now();

        // Continuously fetch and print new messages
        while (true) {
            ResourceSet<Message> messages = Message.reader()
                    .setTo(TwilioConsts.WHATSAPP_NUMBER)
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
                if (lastMessage == null || isNotTheSameMessage(latestMessage, lastMessage)) {
                    log.info(latestMessage.getBody());
                    switch (latestMessage.getBody()) {
                        case "1":
                        case "2":
                        case "3":
                            writeMessageService.writeMessage("Please choose Favorite area in Floor-" + latestMessage.getBody().trim()
                                    + ": " +
                                    "\nA. \uD83D\uDFE1 (yellow)" +
                                    "\nB. \uD83D\uDD35 (blue)" +
                                    "\nC. \uD83D\uDD34 (red)" +
                                    "\nD. \uD83D\uDFE3 (purple)");
                            break;
                        case "A":
                        case "B":
                        case "C":
                        case "D":
                            writeMessageService.writeMessage("The available seats there are: " +
                                    "\nSeat " + latestMessage.getBody() + "1" +
                                    "\nSeat " + latestMessage.getBody() + "3" +
                                    "\nSeat " + latestMessage.getBody() + "7" +
                                    "\n\n" + "‼️Please type the seat you want including the word \"Seat\" at the    beginning");
                            break;
                        default:
                            if (latestMessage.getBody().contains("Seat")) {
                                writeMessageService.writeMessage(latestMessage.getBody() + " was Occupied Successfully," +
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
                Thread.sleep(TwilioConsts.DELAY_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isNotTheSameMessage(Message msg1, Message msg2) {
        return !(msg1.getBody().equals(msg2.getBody()));
    }
}
