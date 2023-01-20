package pro.sky.recipebookcourse3.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FirstController {
    @GetMapping
    public String hello() {
        return "Приложение запущено";
    }
    @GetMapping("info")
    public String info() {
        return "Автор: Ермакова Анна. " +
                "Название проекта: Recipe book. " +
                "Дата создания проекта: 03/01/2023. " +
                "Описание проекта: Приложение для сайта рецептов.";
    }
}
