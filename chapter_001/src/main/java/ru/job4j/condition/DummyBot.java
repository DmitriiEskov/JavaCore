package ru.job4j.condition;

/**
 * Class for the Dummy Bot.
 *
 * @author Dmitrii Eskov (dmitryhope@yahoo.com)
 * @version 1.0
 * @since 06.06.2018
 */
public class DummyBot {

    /**
     * Answering questions.
     * @param question Client's question
     * @return Answer
     */
    public String answer(String question) {
        String rsl = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}
