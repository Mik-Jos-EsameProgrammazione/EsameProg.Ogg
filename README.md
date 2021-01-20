# Wind Field Operator
 <div align="center">
  <br><br>
  <img src="https://raw.githubusercontent.com/bugsounet/MMM-Weather/master/logo.png" width="260"></img>
  <br>
  <h4>Versione attuale: 1.1.3</h4><br>
  <p>
    <a href="#obiettivo">Obiettivo</a>&nbsp•
    <a href="#realizzazione">Realizzazione</a>&nbsp•
    <a href="#guida">Guida per l'uso</a>&nbsp•
    <a href="https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/tree/main/doc/esame_prog_meteo">Javadoc</a>&nbsp•
    <a href="#autori">Autori</a> 
    <!-- vanno modificati tutti i riferimenti -->
  </p>
</div><br><br>

## OpenWeather Service
**OpenWeatherMap** è un servizio online, di proprietà di OpenWeather Ltd, che fornisce dati meteorologici globali , inclusi dati meteorologici attuali, previsioni , nowcast e dati storici (a partire dal 1979), utilizzando servizi di trasmissione meteorologica e dati grezzi da stazioni meteorologiche aeroportuali, stazioni radar e altre stazioni meteorologiche

Fornisce più di venti APImeteo e ha un'abbondanza di repository su GitHub. Le API supportano più lingue, unità di misura e formati di dati.

## Obiettivo
Tramite la lettura di un apposita **API** vengono ricercati tutti dati riguardanti il **meteo** e vengono inseriti in una specifica Data-list ogni ora. Una volta configurati i parametri necessari alla lettura (es. nome della città, es. *APIkey*) l'applicazione tramite un collegamento via Internet effettua la lettura, elabora i dati in base alle specifiche scelte e restituisce i risultati tramite un apposito Web Service di nome *Spring Boot*. Infine, la lettura dei risultati avviene tramite una chiamata ad uno speciale indirizzo **HTTP** con il passaggio dei parametri desiderati.


# Realizzazione

Per procedere alla realizzazione del progetto è stato necessario conoscere la documentazione di [OpenWeather](https://openweathermap.org/current#name). In seguito si è modellato il [diagramma dei casi d'uso](#diagramma-dei-casi-uso) evidenziando tutte le richieste che un utente può fare. Sulla base di questo diagramma si è modellato il [diagramma delle classi](#diagramma-delle-classi) utile alla vera e propria stesura del codice. Di seguito sono stati effettuati eventuali test per controllare il corretto funzionamento dell'applicazione.


## Diagramma dei Casi Uso

**Digramma Amministratore**

![enter image description here](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/MeteoUsesCase/use_case_images/use_case_amministratore.png?raw=true)

Questo schema descrive la gestione del programma e le interazioni tra il sistema e l'utente.


**Diagramma Utente**

![enter image description here](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/MeteoUsesCase/use_case_images/use_case_utente.png?raw=true)

Questo diagramma dei casi d'uso illustra tutte le azioni che un utente può compiere per utilizzare l'applicazione. 
Queste ultime possono essere eseguite tramite un apposito Software chiamato [Postman](#software-utilizzati) richamando le apposite [rotte](#guida) descritte di seguito
## Diagramma delle classi

#### Package Controller
![enter image description here](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/ClassDiagrams/controller.jpg?raw=true)

- La classe *SpringController* contiene tutti gli attributi e i metodi necessari  per la restituzione dei risultati tramite l'utilizzo del Web Service SpringBoot, semplicemente chiamando tramite un apposita applicazione un indirizzo, specificando le diverse rotte. Ogni rotta poi corrisponderà ad uno specifico metodo della classe e restiruira uno specifico risultato.
 - La classe SpringController importa tutti i package del progetto poiché è la classe che gestisce tutte le richieste fatte dall'utente.

#### Package MeteoDati
![enter image description here](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/main/ClassDiagrams/datimeteo.jpg?raw=true)

- La classe *DatiMeteo* contiene tutte le informazioni necessarie al riconoscimento della località dove avvengono le misurazioni meteo (es.  data della misura, fuso orario, nome e codice della città che viene considerata)
- La classe *Vento* contiene le informazioni relative al vento della determinata città (es. velocità, direzione e ipotetiche raffiche)
- Dalla classe *DatiMeteo* sono stati ricavati alcuni metadati.
- La classe *Vento* è quella che contiene tutte le informazioni relative alla sezione <code> "wind":. . . </code>
- La classe *MeteoDataBase* è la classe che contiene tutti i dati immagazzinati dall'avvio dell'applicazione.
#### Package Filtri
![enter image description here](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/ClassDiagrams/filtri.jpg?raw=true)

- Questo packege contiene le classi necessarie all'applicazione dei filtri sui dati immagazzinati dall'applicazione. I metodi all'interno delle classi restituiscono un *Vector* di oggetti vento relativo al periodo filtrato.
- Contiene un intrefaccia Filtraggio che dichiara un metodo <code> filtro(){ . . .} </code> definito poi nelle classi **FiltroGiornaliero**, **FiltroSettimanale** e **FiltroMensile**.
- FiltroPersonalizzato definisce un metodo <code> filtroPersonalizzato() { . . .} </code> per particolari richieste dell'utente.
#### Package GestioneJson 
![enter image description here](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/main/ClassDiagrams/gestionejson.jpg?raw=true)

- Contiene delle classi utili alla gestione delle risposte ricevute dalla chiamata API.
- La classe ConvertiJSON contiene tutti i metodi e gli attributi necessari alla conversione dei dati restituiti dalla chiamata all'API di OpenWeather, al popolamento degli oggetti Vento tramite i dati forniti e alla restituzione dei metadati di ogni database.
- Le classi ScriviJson e LeggiJson consentono un ipotetico salvataggio dei dati su dei file formattati.
- La classe APICall si occupa della chiamata all'API dell servizio OpenWeather restituendo un stringa contenente la lettura.
- JSONTimer permette di effettuare le letture ogni periodo definito (esempio ogni ora).
- JSONTimerTask è la classe che definisce le istruzioni da eseguire ogni periodo (queste istruzioni verranno poi eseguite dalla classe JSONTimer).
#### Package Statistiche
![enter image description here](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/main/ClassDiagrams/statistiche.jpg)

- È il package che contiene tutte le classi utili al calcolo delle statistiche che soddisfano le richieste della consegna.
- È presente anche un interfaccia **StatsInterface** che dichiara il metodo <code> getRisStats(){. . .} </code> definito poi nelle classi **StatDirezioneMedia**, **StatVelocitaMin**, **StatVelocitaMax**,  **StatVelocitaMedia**, **StatVarianzaVelocita** e  **StatVarianzaDirezione**.
- Le classi appena descritte definiscono, appunto, il metodo che restituisce il valore della statistica in base al nome della classe che lo contiene (es. lo stesso metodo nella classe StatDrirezioneMedia restituisce la direzione media del vento, mentre nella classe StatVelocitaMin restituisce la velocità minima del vento).
#### Package Exception
![](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/main/ClassDiagrams/exception.jpg?raw=true)

- Contiene tutte le classi d'eccezione definite.
- La classe EmptyArrayException definisce un eccezione che viene lanciata se si tenta di lavorare su un array vuoto e la classe non lo permette.
- La classe NoConvertionException definisce un eccezione che viene lanciata se non è possibile fare la conversione da JSONArray ad un oggetto della classe vento e viceversa identificando la posizione dove viene interrotta la conversione.
- La classe InvalidNameException definisce un eccezione che viene lanciata quando viene passato un argomento non valido per un determinato metodo.
#### Package Test
 <div align="center">
<img src="https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/ClassDiagrams/test.jpg?raw=true" width="800"></img>
</div>

- Questo package contiene alcuni classe che effettuano dei test sulle omonime classi restituendo error o failure nel caso che vengano forniti dei risultati diversi da quelli attesi.
## Guida
|Rotte|Descrizione|
|--|--|
|[*/metadata*](#rotta-metadata) |Restituisce i  metadati di tutte le letture effettuate dall'avviamento dell'applicazione|
|[*/data*](#rotta-data)|Restituisce i dati di tutte le letture effettuate dall'avviamento dell'applicazione |
|[*/configuration*](#rotta-configuration)|Configura l'applicazione ad effetuare letture su determinate città inserite come parametro
|[*/filter*](#rotta-filter)|Configura tutti i filtri da applicare ai dati (filtri pre-definiti)
|[*/custom_filter*](#rotta-custom_filter)|Configura un filtro da applicare ai dati sotto un particolare periodo inserito dall'utente 
|[*/remove_filter*](#rotta-remove_filter)|Rimuove tutti i filtri pre-inseriti 
|[*/stats*](#rotta-stats) | Restituisce i valori di tutte le statistiche inserite come parametro

### Rotta /metadata  
*Restituisce i metadati dei dati immagazzinati dall'avvio dell'applicazione*

Chiamata da effettuare per ricevere i metadati: 
<code>http://localhost:8080/metadata</code>

Risposta alla chiamata a questo indirizzo:
![enter image description here](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/other_images/metadata.png?raw=true)<br>
Oltre ad alcune informazioni relative al riconoscimento della località su cui fare le misurazioni è stato anche inserito un contatore che identifica il numero progressivo di quando viene immagazzinato il dato.

### Rotta /data
*Restituisce i dati immagazzinati dall'avvio dell'applicazione*

Chiamata da effettuare per ricevere i dati: 
<code>http://localhost:8080/data</code>

Risposta alla chiamata a questo indirizzo:
![enter image description here](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/other_images/data.png?raw=true)
Rappresenta un JSONObject contenente tutte le informazioni divise per tipo.

|Tipo|Descrizione|
|--|--|
|rain|Quantità d'acqua caduta in un ora (mm)|
|coord|Coordinate della località su cui vengono fatte le misurazioni|
|general_information||
|weather|Informazioni relative al meteo|
|main|Informazioni relative alla temperatura, umidità e pressione|
|clouds|Informazione relative alla nuvolosità|
|sys|Informazioni relative allo stato in cui si trova la località|
|wind|Informazioni relative alla direzione, velocità e raffica del vento|

### Rotta /configuration
*Permette di impostare il sistema inserendo la località su cui effettuare le misurazioni e l'APIkey necessaria all'accesso*

Chiamata da effettuare per ricevere i dati: 
<code>http://localhost:8080/configuration?city=Montegiorgio&APIKey=19424eeea64914627b18e861c3ae0688</code>

Risposta alla chiamata a questo indirizzo:
![](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/other_images/configuration.png?raw=true)

### Rotta /filter
|Rotte|Descrizione|
|--|--|
|[FiltroGiornaliero](#rotta-filtrogiornaliero)| Imposta un filtro ristretto alle ultime 24H
|[FiltroSettimanale](#rotta-filtrosettimanale)| Imposta un filtro ristretto agli ultimi sette giorni
|[filtroMensile](#rotta-filtromensile)| Imposta un filtro ristretto agli ultimi trenta giorni

### FiltroGiornaliero
*Applica ai dati immagazzinati un filtro relativo alle ultime 24H.*

Chiamata da effettuare per applicare questo determinato filtro:
<code> http://localhost:8080/filter?type=FiltroGiornaliero </code>

Risposta della chiamata a questo indirizzo:
![](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/filter_images/FiltroGiornaliero.png?raw=true)

### FiltroSettimanale
*Applica ai dati immagazzinati un filtro relativo agli ultimi 7 giorni.*

Chiamata da effettuare per applicare questo determinato filtro:
<code> http://localhost:8080/filter?type=FiltroSettimanale </code>

Risposta della chiamata a questo indirizzo:
![](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/filter_images/FiltroSettimanale.png?raw=true)

### FiltroMensile
*Applica ai dati immagazzinati un filtro relativo agli ultimi 30 giorni.*

Chiamata da effettuare per applicare questo determinato filtro:
<code> http://localhost:8080/filter?type=FiltroMensile </code>

Risposta della chiamata a questo indirizzo:
![](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/filter_images/FiltroMensile.png?raw=true)

### FiltriCombinati
Possono essere combinati più filtri semplicemente aggiungendo un parametro all'indirizzo da chiamare. In questo caso verranno filtrati i dati in base al numero e alla tipologia di filtri (es. se vengono scelti FiltroGiornaliero e FiltroSettimanale l'applicazione lavorerà sia sui dati delle ultime 24H e su quelli degli ultimi 7 giorni).

 Chiamata da effettuare per applicare questo determinato filtro:
<code> http://localhost:8080/filter?type=FiltroGiornalieroe&type=FiltroSettimanale&type=FiltroMensile </code>

Risposta della chiamata a questo indirizzo:
![](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/filter_images/FiltriCombinati.png?raw=true)

### Rotta /custom_filter
*Applica ai dati immagazzinati un filtro relativo al periodo inserito come parametro della chiamata*
In questo caso è possibile scegliere il range in base alle:
 - Ore 
- Giorni
- Settimane
- Mesi
- Anni
  
  

Chiamata da effettuare per applicare questo determinato filtro:
<code>http://localhost:8080/custom_filter?period=2_ore </code>

Risposta della chiamata a questo indirizzo:
![](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/filter_images/FiltroPersonalizzato.png?raw=true)

Anche in questo caso possono essere inseriti più filtri basati su range diversi aggiungendo semplicemente parametri all'indirizzo scritto in precedenza.

Chiamata da effettuare per applicare questo determinato filtro:
<code>http://localhost:8080/custom_filter?period=2_ore&period=2_giorni&period_2_mesi </code>
*(bisogna fare attenzione a inserire l'underscore tra il valore e il tipo dell periodo es. 2 **_** giorni)*

Risposta della chiamata a questo indirizzo:
![](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/filter_images/FiltroPersonalizzatoCombinato.png?raw=true)

### Rotta /remove_filter
Vedere descrizione tabella
### Rotta /stats
|Rotte|Descrizione|
|--|--|
|StatDirezioneMedia| Restituisce il valore della media della direzione del vento
|StatVarianzaDirezione| Restituisce il valore della varianza della direzione del vento
|StatVelocitaMedia| Restituisce il valore della media della velocità del vento
|StatVarianzaVelocita| Restituisce il valore della varianza della velocita del vento
|StatVelocitaMin| Restituisce il valore minimo della velocità del vento
|StatVelocitaMax| Restituisce il valore massimo della velocità del vento

### StatDirezioneMedia
*Restituisce il valore della media della direzione del vento*

Chiamata da effettuare per applicare questa determinata statistica:
<code>http://localhost:8080/stats?type=StatDirezioneMedia </code>

Risposta della chiamata a questo indirizzo:
![](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/stat_images/Schermata%202021-01-16%20alle%2014.09.02.png?raw=true)

### StatVarianzaDirezione
*Restituisce il valore della varianza della direzione del vento*

Chiamata da effettuare per applicare questa determinata statistica:
<code>http://localhost:8080/stats?type=StatVarianzaDirezione </code>

Risposta della chiamata a questo indirizzo:
![](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/stat_images/Schermata%202021-01-15%20alle%2016.19.13.png?raw=true)

### StatVelocitaMedia
*Restituisce il valore della media della velocità del vento*

Chiamata da effettuare per applicare questa determinata statistica:
<code>http://localhost:8080/stats?type=StatVelocitaMedia </code>

Risposta della chiamata a questo indirizzo:
![](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/stat_images/Schermata%202021-01-15%20alle%2016.19.24.png?raw=true)

### StatVarianzaVelocita
*Restituisce il valore della varianza della velocita del vento*

Chiamata da effettuare per applicare questa determinata statistica:
<code>http://localhost:8080/stats?type=StatVarianzaVelocita </code>

Risposta della chiamata a questo indirizzo:
![](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/stat_images/Schermata%202021-01-15%20alle%2016.19.05.png?raw=true)

### StatVelocitaMin
*Restituisce il valore minima della velocità del vento*

Chiamata da effettuare per applicare questa determinata statistica:
<code>http://localhost:8080/stats?type=StatVelocitaMin </code>

Risposta della chiamata a questo indirizzo:
![](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/stat_images/Schermata%202021-01-15%20alle%2016.18.58.png?raw=true)

### StatVelocitaMax
*Restituisce il valore massimo della velocità del vento*

Chiamata da effettuare per applicare questa determinata statistica:
<code>http://localhost:8080/stats?type=StatVelocitaMax </code>

Risposta della chiamata a questo indirizzo:
![](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/stat_images/Schermata%202021-01-15%20alle%2016.18.49.png?raw=true)

### Statistiche Combinate
*Restituisce tutte le statistiche che vengono messe nella chiamata all'indirizzo*

Chiamata da effettuare per applicare queste statistiche:
<code>http://localhost:8080/stats?type=StatDirezioneMedia&type=StatVelocitaMax&type=StatVelocitaMin&type=StatVarianzaVelocita&type=StatVarianzaDirezione&type=StatVelocitaMedia </code>

Risposta della chiamata a questo indirizzo:
![](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/stat_images/stat_nofilter.png?raw=true)

In questo caso non sono stati applicati i filtri e quindi le statistiche vengono calcolate su tutti i dati immagazzinati dall'avvio dell'applicazione

### Statistiche Combinate Filtro Giornaliero
*Restituisce il risultato delle statistiche inserite nella chiamata sulla base dei dati registrati nell'ultimo giorno trascorso*

Chiamata da effettuare per applicare queste statistiche:
<code>http://localhost:8080/stats?type=StatDirezioneMedia&type=StatVelocitaMax&type=StatVelocitaMin&type=StatVarianzaVelocita&type=StatVarianzaDirezione&type=StatVelocitaMedia </code>

Ovviamente è possibile richiedere una sola statistica o più di una.

(In questo caso la chiamata da effettuare per richiedere le statistiche è la stessa della precedente, in questo caso pero in precedenza è stato settato un filtro tramite la rotta <code>/filter </code>)

Risposta della chiamata a questo indirizzo:
![](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/stat_images/stat_filtro_giornaliero.png?raw=true)


### Statistiche Combinare Filtro Settimanale 
*Restituisce il risultato delle statistiche inserite nella chiamata sulla base dei dati registrati nell'ultima settimana trascorsa*

Chiamata da effettuare per applicare queste statistiche:
<code>http://localhost:8080/stats?type=StatDirezioneMedia&type=StatVelocitaMax&type=StatVelocitaMin&type=StatVarianzaVelocita&type=StatVarianzaDirezione&type=StatVelocitaMedia </code>

Ovviamente è possibile richiedere una sola statistica o più di una.

(In questo caso la chiamata da effettuare per richiedere le statistiche è la stessa della precedente, in questo caso pero in precedenza è stato settato un filtro tramite la rotta <code>/filter </code>)

Risposta della chiamata a questo indirizzo:
![](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/stat_images/stat_filtro_settimanale.png?raw=true)


### Statistiche Conbinate Filtro Mensile
*Restituisce il risultato delle statistiche inserite nella chiamata sulla base dei dati registrati nell'ultimo mese trascorso*

Chiamata da effettuare per applicare queste statistiche:
<code>http://localhost:8080/stats?type=StatDirezioneMedia&type=StatVelocitaMax&type=StatVelocitaMin&type=StatVarianzaVelocita&type=StatVarianzaDirezione&type=StatVelocitaMedia </code>

Ovviamente è possibile richiedere una sola statistica o più di una.

(In questo caso la chiamata da effettuare per richiedere le statistiche è la stessa della precedente, in questo caso pero in precedenza è stato settato un filtro tramite la rotta <code>/filter </code>)

Risposta della chiamata a questo indirizzo:
![](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/stat_images/stat_filtro_mensile.png?raw=true)

### Statistiche con filtri multipli
- Ovviamente è possibile, come illustrato in precedenza, impostare un numero variabile di filtri contemporaneamente. In questo caso effettuando la chiamata per le statistiche combinate o semplicemente quella per un statistica specifica si avranno valori diversi per ogni periodo.

*Restituisce le statistiche selezionate calcolate sulla base dei dati filtrati*

Chiamata da effettuare: 
In questo caso si può scegliere di calcolare tutte le statistiche, più di una o una sola con la chiamata illustrata fin ora.

(Tramite la rotta <code> /filter </code> possono essere impostati uno o più filtri) 

Risposta alla chiamata:
![](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/Joshua-Ciccolini-UMLScheme/stat_images/stat_comb_filtri.jpg?raw=true)
## Diagrammi delle Sequenze 

### Diagramma delle sequenza del metodo che restituisce le statistiche 
![enter image description here](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/main/DiagrammaSequenze/getComboStats.png?raw=true)
Questo schema fa riferimento alla chiamata <code> GET /stats</code> che restituisce il valore di una determinata statistica in base al nome che viene passato come parametro. In questo caso viene calcolata una statistica instanizando, tramite il metodo <code> istanziateStatClass() </code>, una corrispondente a quella statistica passandogli i dati su cui effettuare i calcoli. Questa operazione viene fatta per ogni statistica da calcolare e i risultati vengono inseriti in un vettore di oggetti Statistiche. In seguito, se sono stati impostati dei filtri, i risultati vengono inseriti in una collezione, collegandoli al nome del filtro applicato. (Anche questa operazione viene fatta per ogni filtro applicato).
 
### Diagramma delle sequenze del metodi che restituisce i metadati 
![enter image description here](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/main/DiagrammaSequenze/getMetaDati.png?raw=true)
Questo schema fa riferimento alla chiamata <code> GET /metadata</code> che restituisce i metadati delle misurazioni effettuate. In questo caso viene richiamato il metodo <code> getMetaDati()</code> del database che a sua volta utilizza un metodo <code>getMeta()</code> della classe ConvertiJSON per ricavare i metadati dalle misurazioni effettuate.
### Diagramma delle sequenze che restituisce i dati
![enter image description here](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/main/DiagrammaSequenze/getdati.png?raw=true)
Questo schema fa riferimento alla chiamata <code>GET /data</code> che restituisce i dati immagazzinati dall'avvio dell'applicazione. In questo caso viene richiamato il metodo <code>getDati()</code> del database.
### Diagramma delle sequenze che permette di configurare il sistema
![enter image description here](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/main/DiagrammaSequenze/setConfiguration.png?raw=true)

### Diagramma delle sequenze che permette di impostare il filtro personalizzato
![enter image description here](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/main/DiagrammaSequenze/setCustomFilter.png?raw=true)
Questo schema fa riferimento alla chiamata <code> GET /custom_filter</code> che permette di impostare filtri con determinati periodi forniti come parametri. In questo caso viene instanizato un oggetto della classe FiltroPersonalizzato e viene usato il metodo <code> filtroPersonalizzato()</code> per ottenere un vettore filtrato in base al valore del parametro passato a questo metodo (il parametro deve essere formattato come "valore_periodo") e viene inserito in una collezione contenente tutti i dati con i filtri applicati. Ovviamente è possibile instanziare più di un filtro, questi vengono poi considerati quando vengono calcolate le statistiche.
### Digramma delle sequenze che permette di impostare i filtri predefiniti
![enter image description here](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/blob/main/DiagrammaSequenze/setFilter.png?raw=true)
Questo schema fa riferimento alla chiamata <code> GET /filter</code> che permette di impostare i filtri predefiniti. In questo caso viene richiamato il metodo ausiliario <code>instaniziateFilterClass()</code> che instanzia un oggetto della classe corrispondente al filtro passato come parametro. Utilizzano il metodo <code> filtro()</code> del nuovo oggetto si ottiene un vettore filtrato che viene inserito nella collezione che contiene i dati filtrati, ovviamente collegandoli al tipo del filtro applicato. 

La chiamata <code>GET /remove_filter</code> richiama semplicemente il metodo <code>clear()</code> della collezione rimuovendo tutti i dati filtrati. In questo caso i dati verranno contrassegnati dalla chiave "No Filter" e le statistiche verranno calcolate su tutti i dati immagazzinati dall'avvio dell'applicazione.

## Documentazione
Nella cartella <code> doc/esame_prog_meteo </code> è possibile trovare tutta la documentazione relativa alle classi utilizzate per la realizzazione della applicazione

È è possibile trovare la documentazione qui: https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg/tree/main/doc/esame_prog_meteo
## Software Utilizzati
- [**Eclipse**](https://www.eclipse.org)
    -  È un ambiente di sviluppo integrato multi-linguaggio,  libero e distribuito sotto i termini della Eclipse Public License.
- [**UMLDesigner**](http://www.umldesigner.org)
	 - UML Designer è uno strumento UML open source basato su Sirius ed Eclipse. 
- [**Postman**](https://www.postman.com)
	- Semplifica ogni passaggio della creazione di un'API e ottimizza la collaborazione in modo da poter creare API migliori, più velocemente. 
- [**Microsoft Teams**](https://www.microsoft.com/it-it/microsoft-365/microsoft-teams/download-app)
	- è una piattaforma di comunicazione e collaborazione unificata che combina chat di lavoro persistente, teleconferenza, condivisione di contenuti (incluso lo scambio e il lavoro simultaneo sui file) e integrazione delle applicazioni. 

## Servizi Utilizzati
- **SpringBoot** 
	-  È un framework open source per lo sviluppo di applicazioni su piattaforma Java. 
	Con Spring Boot, è possibile creare una applicazione avente un metodo main che lancia l'intera applicazione web, compreso il web server integrato. Nel caso in cui si abbia necessità di generare dei pacchetti di tipo war da usare all'interno di web server a partire da progetti Spring Boot, è possibile usare il plugin di Maven o quello di Gradle.
- [**JavaDoc**](https://docs.oracle.com/en/java/)
- [**Spring Initializr**](https://start.spring.io/)
- [**GitHub**](https://github.com/Mik-Jos-EsameProgrammazione/EsameProg.Ogg.git)
	
## Autori
- Joshua Ciccolini 
- Michele Di Renzo
