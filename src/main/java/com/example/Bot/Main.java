package com.example.Bot;


import java.util.ArrayList;
import java.util.List;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends TelegramLongPollingBot{
    @Override
    public String getBotUsername() {
        // Thay thế bằng tên người dùng bot của bạn
        return "Trader";
    }

    @Override
    public String getBotToken() {
        // Thay thế bằng token của bạn từ BotFather
        return "7543634999:AAFoEWl-VpR86cZoNZIO7FjXAeyausTlKp4";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            if (messageText.equals("/start")) {
                SendMessage message = new SendMessage();
                message.setChatId(String.valueOf(chatId));
                message.setText("Nhấn vào một trong các nút dưới đây để mở ứng dụng:");

                // Tạo các nút với URL
                InlineKeyboardButton button1 = new InlineKeyboardButton();
                button1.setText("Open App 1");
                button1.setUrl("https://www.youtube.com/");

                InlineKeyboardButton button2 = new InlineKeyboardButton();
                button2.setText("Open App 2");
                button2.setUrl("https://www.youtube.com/");

                InlineKeyboardButton button3 = new InlineKeyboardButton();
                button3.setText("Open App 3");
                button3.setUrl("https://www.youtube.com/");

                InlineKeyboardButton button4 = new InlineKeyboardButton();
                button4.setText("Open App 4");
                button4.setUrl("https://www.youtube.com/");

                // Tạo hàng 1 với 2 nút
                List<InlineKeyboardButton> rowInline1 = new ArrayList<>();
                rowInline1.add(button1);
                rowInline1.add(button2);

                // Tạo hàng 2 với 2 nút
                List<InlineKeyboardButton> rowInline2 = new ArrayList<>();
                rowInline2.add(button3);
                rowInline2.add(button4);

                // Thêm các hàng vào danh sách hàng
                List<List<InlineKeyboardButton>> rowsInline = new ArrayList<>();
                rowsInline.add(rowInline1);
                rowsInline.add(rowInline2);

                // Thêm danh sách hàng vào bàn phím
                InlineKeyboardMarkup markupInline = new InlineKeyboardMarkup();
                markupInline.setKeyboard(rowsInline);

                // Thêm bàn phím vào tin nhắn
                message.setReplyMarkup(markupInline);

                try {
                    execute(message); // Gửi tin nhắn
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
    	System.out.println("dsad");
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new Main());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}