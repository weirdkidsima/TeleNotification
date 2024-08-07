package com.stupnikov.notification_bot.bot;

import com.stupnikov.notification_bot.configuration.TelegramProperties;
import com.stupnikov.notification_bot.service.UpdateDispatcher;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class Bot extends TelegramWebhookBot {
    TelegramProperties properties;
    UpdateDispatcher updateDispatcher;

    public Bot(TelegramProperties properties, UpdateDispatcher updateDispatcher) {
        super(properties.getToken());
        this.properties = properties;
        this.updateDispatcher = updateDispatcher;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return updateDispatcher.distribute(update);
    }

    @Override
    public String getBotPath() {
        return properties.getUrl();
    }

    @Override
    public String getBotUsername() {
        return properties.getName();
    }
}
