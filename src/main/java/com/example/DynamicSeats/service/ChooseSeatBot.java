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
        writeMessageService.writeMessage("Hello " + TwilioConsts.WHATSAPP_USER_NAME + "\nFrom Department הפצת מידע ללקוחות" +
                ",\nWelcome to the seats choose bot \n" +
                "Please Choose on which Floor do you want to seat today?" +
                "\n1 \n2 \n3");

        Message lastMessage = null;

        // Continuously fetch and print new messages
        while (true) {
            ResourceSet<Message> messages = Message.reader()
                    .setTo(TwilioConsts.WHATSAPP_NUMBER)
                    .setDateSentAfter(ZonedDateTime.now())
                    .read();

            // Get the latest message if there are any new messages
            List<Message> messageList = new ArrayList<>();
            for (Message msg : messages) {
                messageList.add(msg);
            }
            if (!messageList.isEmpty()) {
                Message latestMessage = messageList.get(0);

                // If the latest message is different than the last message,
                // print the message and send Response
                if (!latestMessage.equals(lastMessage)) {
                    log.info(latestMessage.getBody());
                    switch (latestMessage.getBody()) {
                        case "1":
                        case "2":
                        case "3":
                            writeMessageService.writeMessage("Please choose Favorite area in Floor" + latestMessage.getBody()
                                    + ": \nA\nB\nC\nD");
                            break;
                        case "A":
                        case "B":
                        case "C":
                        case "D":
                            writeMessageService.writeMessage("The available seats there are: \nSeat a1\nSeat b3\nSeat c7" +
                                    "\nPlease type the seat you want including the word \"Seat\" at the beginning");
                            break;
                        default:
                            if (latestMessage.getBody().contains("Seat")) {
                                writeMessageService.writeMessage(latestMessage.getBody() + " was Occupied Successfully," +
                                        "\nIt will be yours until the end of the day, \nHave a nice day.");
                            } else {
                                writeMessageService.writeMessage("Not Available option, Please try again");
                            }
                            break;
                    }
                    lastMessage = latestMessage;
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
}
