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
        return "overone_picture_bot";
    }

    @Override
    public String getBotToken() {
        return "5530700213:AAFeWy0uLPY2R6ZN8nkZl1KVffOKB3IW6dg";
    }

    //cat AgACAgIAAxkBAAMOY35hT-vj03iM8ENwV6s2ncHjHHoAAvrFMRuZifBLTxPyAn685DkBAAMCAANzAAMrBA
    //dog AgACAgIAAxkBAAMQY35h2ThBJcqTNF_tz05hFSiRbmAAAvPCMRvFRflLFDf8UXoMLpUBAAMCAANzAAMrBA
    //fox AgACAgIAAxkBAAMXY35igRWxCCziCzloO7PPSIlk0nsAAvnCMRvFRflLy5bPBsWXt6UBAAMCAANzAAMrBA
    //raccoon AgACAgIAAxkBAAMTY35iBmO7RvX5QqjAKbY3ZlBnd28AAvbCMRvFRflLRLSRTYfskCMBAAMCAANzAAMrBA
    //tiger AgACAgIAAxkBAAMVY35iH--qOTY1ElzB5uaeRXysNQoAAvjCMRvFRflLbW9xSqJ9GpUBAAMCAANzAAMrBA

    @Override
    public void onUpdateReceived(Update update) {

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
        switch (update.getMessage().getText()) {
            case "Cat":
                inputFile.setMedia("AgACAgIAAxkBAAMOY35hT-vj03iM8ENwV6s2ncHjHHoAAvrFMRuZifBLTxPyAn685DkBAAMCAANzAAMrBA");
                break;
            case "Dog":
                inputFile.setMedia("AgACAgIAAxkBAAMQY35h2ThBJcqTNF_tz05hFSiRbmAAAvPCMRvFRflLFDf8UXoMLpUBAAMCAANzAAMrBA");
                break;
            case "Fox":
                inputFile.setMedia("AgACAgIAAxkBAAMXY35igRWxCCziCzloO7PPSIlk0nsAAvnCMRvFRflLy5bPBsWXt6UBAAMCAANzAAMrBA");
                break;
            case "Raccoon":
                inputFile.setMedia("AgACAgIAAxkBAAMTY35iBmO7RvX5QqjAKbY3ZlBnd28AAvbCMRvFRflLRLSRTYfskCMBAAMCAANzAAMrBA");
                break;
            case "Tiger":
                inputFile.setMedia("AgACAgIAAxkBAAMVY35iH--qOTY1ElzB5uaeRXysNQoAAvjCMRvFRflLbW9xSqJ9GpUBAAMCAANzAAMrBA");
                break;


        }
        try {
            execute(sendPhoto);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }


    }
}
