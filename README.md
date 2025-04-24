# 🔢 Sudoku
- Jogo desenvolvido como resolução de um curso trilha java  da plataforma <i>DIO</i>.
---
#### O Jogo
- Desenvolvido em java 17
- Roda no console
- Menu de opções

---  
#### ⚠️ Notas do desenvolvimento ⚠️
- Embora o desafio possibilita-se fork de um projeto oferecido pelo curso, optei por um projeto próprio, iniciado do zero, o que torna mais díficil e de melhor aproveitamento para o conhecimento, que é a principal meta. 
- Dentre pequenas diferenças, fiz o seed dentro do método de uma classe e não passei por argumentos, fiz isso não por desconhecimento, mas como o projeto veio do zero, é mais fácil depois atualizar diversas outras grades de jogo, coisa que é mais sucetivel ao erro passar um monte de parametros.
- Também juntei a função de jogo atual com status do jogo, assim, em status, a grade atual é apresentada e abaixo o status do game é mostrado.
---
#### Menu
- **Jogar**  captura linha, coluna e jogada
- **Status** Mostra o jogo atual e se existe algum erro 
- **apagar jogada** captura linha e coluna e apaga jogada nesta, desde de que não seja local seed do jogo.
- **Retroceder última jogada** volta último movimento.
- **Reinicia o tabuleiro** traz o jogo devolta ao inicio do seed.
- **Sair** fecha o aplicativo.
---
#### Considerações
- É um jogo simples e funcional, prove as checagens logícas de linhas, colunas e setores(os 9 quadrados com 9 algarismos).
- Ao final, se tudo correto, o status mostrará "Você venceu, concluiu o desafio".
---


