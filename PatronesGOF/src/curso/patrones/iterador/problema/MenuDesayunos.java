package curso.patrones.iterador.problema;

public class MenuDesayunos {
	ItemMenu[] itemsMenu=new ItemMenu[3];
	
	
	public void añadir(ItemMenu item){
		int hueco=-1;
		for (int i = 0; i < itemsMenu.length; i++) {
			if(itemsMenu[i]==null){
				hueco=i;
				break;
			}
		}
		if(hueco!=-1)
			itemsMenu[hueco]=item;
		else
			System.out.println("menu lleno");
	}


	public ItemMenu[] getItemsMenu() {
		return itemsMenu;
	}
	
	

}
