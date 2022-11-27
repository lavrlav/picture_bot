package main;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "picture_by_Olia_bot";
    }

    @Override
    public String getBotToken() {
        return "5733855600:AAFhzoS8pn-sAG0qm0cdZpzCEp6pX0vQkZA";
    }

    //cAT AgACAgIAAxkBAAMEY4H8n2Ov1RoeJlpO9dt2wJPRbfsAAv3EMRsVURFIwwx8P_FB1b0BAAMCAANzAAMrBA
    //dog AgACAgIAAxkBAAMGY4H8zs0cT78AAUGxbzpQWPkNqxuWAAIBxTEbFVERSOS7tx67s_mvAQADAgADcwADKwQ
    //fox AgACAgIAAxkBAAMIY4H886YdeOc18I67YechN67g6AIAAgLFMRsVURFIWhRhVlCeRLEBAAMCAANzAAMrBA
    //raccoon AgACAgIAAxkBAAMKY4H9B5RBV3XCi3YqtyhQzUUnhbsAAgPFMRsVURFI5C_-sJu58FkBAAMCAANzAAMrBA
    //tiger AgACAgIAAxkBAAMMY4H9FcHnQPxwSQcm2gFP-YPmziQAAgTFMRsVURFImXiD-MZGFo8BAAMCAANzAAMrBA

    @Override
    public  void onUpdateReceived(Update update) {
        /*SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        String id = String.valueOf(update.getMessage().getPhoto().get(0).getFileId());
        sendMessage.setText(id);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }*/

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        KeyboardRow keyboardRow1 = new KeyboardRow();
        keyboardRow1.add(new KeyboardButton("Cat"));
        keyboardRow1.add(new KeyboardButton("Dog"));
        keyboardRow1.add(new KeyboardButton("Fox"));

        KeyboardRow keyboardRow2 = new KeyboardRow();
        keyboardRow2.add(new KeyboardButton("Raccoon"));
        keyboardRow2.add(new KeyboardButton("Tiger"));


        List<KeyboardRow> list = new ArrayList<>();
        list.add(keyboardRow1);
        list.add(keyboardRow2);

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(list);
        sendMessage.setText(update.getMessage().getText());
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(update.getMessage().getChatId().toString());
        InputFile inputFile = new InputFile();

        switch  (update.getMessage().getText()) {
            case "Cat":
                inputFile.setMedia("AgACAgIAAxkBAAMEY4H8n2Ov1RoeJlpO9dt2wJPRbfsAAv3EMRsVURFIwwx8P_FB1b0BAAMCAANzAAMrBA");
                break;
            case "Dog":
                inputFile.setMedia("AgACAgIAAxkBAAMGY4H8zs0cT78AAUGxbzpQWPkNqxuWAAIBxTEbFVERSOS7tx67s_mvAQADAgADcwADKwQ");
                break;
            case "Fox":
                inputFile.setMedia("AgACAgIAAxkBAAMIY4H886YdeOc18I67YechN67g6AIAAgLFMRsVURFIWhRhVlCeRLEBAAMCAANzAAMrBA");
                break;
            case "Raccoon":
                inputFile.setMedia("AgACAgIAAxkBAAMKY4H9B5RBV3XCi3YqtyhQzUUnhbsAAgPFMRsVURFI5C_-sJu58FkBAAMCAANzAAMrBA");
                break;
            case "Tiger":
                inputFile.setMedia("AgACAgIAAxkBAAMMY4H9FcHnQPxwSQcm2gFP-YPmziQAAgTFMRsVURFImXiD-MZGFo8BAAMCAANzAAMrBA");
                break;

        }

        sendPhoto.setPhoto(inputFile);
        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }

}
