# SpriteCutter
Простое приложение, которое поможет вырезать часть изображения из целого.
## Компиляция
### Перед сборкой
  1. Убедитесь в наличии Apache Ant
  2. Убедитесь в правильности пути переменной JAVA_HOME для jdk
### Сборка
  1. Скачайте репозиторий
  2. В корне скачанного репозитория запустите ant
  ```
  Например, для windows:
  C:\SpriteCutter_GUI> C:\apache-ant-1.10.1\bin\ant.bat
  ```
  3. При условии отсутствия ошибок при компиляции конечный файл будет находится по адресу
  ```
  SpriteCutter_GUI\out\artifacts\SpriteCutter_GUI_jar\SpriteCutter_GUI.jar
  ```
## Использование
  1. Заполните все необходимые поля:
    1.1. Относительный или абсолютный путь до исходного изображения
    1.2. Координату x, означающую начало нужного участка (x <= 0)
    1.3. Координату y, означающую начало нужного участка (y <= 0)
    1.4. Ширину участка
    1.5. Высоту участка
    1.6. Имя конечного файла. Данный параметр не является обязательным - при отсутсвии значения конечный файл будет назван out.png
  2. Нажмите кнопку "Вырезать"
![alt Стандартное окно](http://res.cloudinary.com/dbpfaoy8w/image/upload/v1494360111/SplitCutter_README_img1_kblv3m.png)
![alt После успешного выполнения](http://res.cloudinary.com/dbpfaoy8w/image/upload/v1494360365/SplitCutter_README_img2_ltuhpz.png)
