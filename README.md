# Time series analysis for omics data

## Goal:
Das Ziel war die Entwicklung eines neues Webtools zur Exploration von Zeitseriendata in Biodatenbanken. In einer Reihe von Forschnungsprojekten werden molekulare Größen mit verschiedenen Omics Technologien gemessen (Proteine, Transkription RNA, Metabolite). Da die biologischen Fragestellungen immer mehr auf der Systemebene gestellt werden, ist es notwendig die molekularen Größen nach verschiedenen Zeitpunkten zu messen, so dass die Reaktion des Systems bzgl. der zeitlichen Komponente und der Dynamik verstanden werden kann. Die Zeitreihen sind vergleichsweise kurz (3< t < 10) und werden für mehrere hundert Moleküle gemessen und in Datenbanken nach experimentellen Parametern aufgeschlüsselt gespreichert. Mit diesem Webtool darf User manuell einen Referenzverlauf in ein Feld des Webbrowsers mit einer Computermaus zeichnen und anschließend ein Retrival System eine gewählte Datenbank nach ähnlichen Zeitverläufen durchsucht und die n ähnlichsten nach Ähnlichkeit sortiert anzeigt werden können, um weitere Details zu diesen Molekülen anzuzeigen.

## Front-End
Angular, Highcharts, DataTable

## Back-End
Srping boot

## Database
MySQL

## Screenshots

Show feature list
![image](https://github.com/xlinxlin/OmicsDataTimeSeriesAnalysis/blob/master/image/show_feature_list.png)

Add feature
![image](https://github.com/xlinxlin/OmicsDataTimeSeriesAnalysis/blob/master/image/add_feature.png)

Update and delete feature
![image](https://github.com/xlinxlin/OmicsDataTimeSeriesAnalysis/blob/master/image/update_delete_feature.png)

Search feature
![image](https://github.com/xlinxlin/OmicsDataTimeSeriesAnalysis/blob/master/image/search.png)

Plotting start
![image](https://github.com/xlinxlin/OmicsDataTimeSeriesAnalysis/blob/master/image/plotting_start.png)

Plotting with Euclidean distance algorithmus
![image](https://github.com/xlinxlin/OmicsDataTimeSeriesAnalysis/blob/master/image/plotting_ed_algo.png)

Plotting with slope distance algorithmus
![image](https://github.com/xlinxlin/OmicsDataTimeSeriesAnalysis/blob/master/image/plotting_sd_algo.png)
