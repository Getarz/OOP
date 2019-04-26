public class MainMenu {
	public static void main(String[] args) {
		FrameGame frame = new FrameGame();
		frame.setVisible(true);
		/*int card[] = new int[52];
		int dekCard[] = new int[52];
		int checkCard[] = new int[52];

		for (int i=0 ; i<card.length ; i++){
			card[i] = i+1;
		}
		for (int i=0 ; i<dekCard.length; i++){
			int random = (int) (Math.random()*52);
			if(i==0){
				dekCard[i] = random;
				checkCard[random] = 1;
			}
			else {
				if(checkCard[random]==0) {
					dekCard[i] = random;
					checkCard[random] = 1;
				}
				else {
					i--;
				}
			}
		}
		for (int i = 0; i < dekCard.length; i++) {
			if(i==0) {
				System.out.print(dekCard[i]+"\t");
			}
			else {
				System.out.print(dekCard[i]+"\t");
				if(i%10==0)
					System.out.println();
			}
			
		}*/
	}
}
