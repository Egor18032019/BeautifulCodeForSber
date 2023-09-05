package sber.code.beautifulcode.schemas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CheckBracketsRequest {
    String text;
}
/*
{
  "text": "Вчера я отправился в поход в лес (это мое любимое место для отдыха) вместе с друзьями. Мы выбрали маршрут, который проходил через горные потоки и поля (для разнообразия). В начале пути погода была отличной, солнце светило ярко, и птицы радостно пели. Однако, когда мы подошли ближе к вершине горы, небо стало покрываться облаками, (как будто природа готовила нам небольшой сюрприз). Несмотря на это, виды были захватывающими, особенно когда мы достигли высшей точки и увидели прекрасный вид на долину (я почувствовал, что все усилия стоили того)."
}
 */