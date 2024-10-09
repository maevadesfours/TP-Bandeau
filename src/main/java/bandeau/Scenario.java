package bandeau;
import java.util.LinkedList;
import java.util.List;

/**
 * Classe utilitaire pour représenter la classe-association UML
 */
class ScenarioElement {

    Effect effect;
    int repeats;

    ScenarioElement(Effect e, int r) {
        effect = e;
        repeats = r;
    }
}
/**
 * Un scenario mémorise une liste d'effets, et le nombre de repetitions pour chaque effet
 * Un scenario sait se jouer sur un bandeau.
 */
public class Scenario {

    private final List<ScenarioElement> myElements = new LinkedList<>();

    /*private class ScenarioPlayer extends Thread {

        private Bandeau b = null;
        public ScenarioPlayer(Bandeau b){
            this.b=b;
        }
        @Override
        public void run(){
            for (ScenarioElement element : myElements){ 
                for(int repeats = 0; repeats<element.repeats; repeats++){
                    element.effect.playOn(this.b);
        }   
    }*/

  


    /**
     * Ajouter un effect au scenario.
     *
     * @param e l'effet à ajouter
     * @param repeats le nombre de répétitions pour cet effet
     */
    public void addEffect(Effect e, int repeats) {
        myElements.add(new ScenarioElement(e, repeats));
    }

    /**
     * Jouer ce scenario sur un bandeau
     *
     * @param b le bandeau ou s'afficher.
     */
    public void playOn(BandeauVerrouillable b) {
        new Thread(
            //"lambda-expresssion"
            () -> {
                //b.verrouille();
                try{
                    //b.deverouille();
                } finally {}
            }).start();
    }

        private void play(Bandeau b){
            verrouEnLecture.lock();
            for (ScenarioElement element: myElements){
                for (int repeats=0; repeats<element.repeats; repeats++){
                    element.effect.playOn(b);
                }
            }
            verrouEnLecture.unlock();
        }
    }
    
        /*for (ScenarioElement element : myElements) {
            for (int repeats = 0; repeats < element.repeats; repeats++) {
                element.effect.playOn(b);
             ScenarioPlayer player = new ScenarioPlayer(b);
             player.start();
            }
        }*/
     
    

