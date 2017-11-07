package viewTest2;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import control.dao.MenuDAO;
import model.Menu;
import model.Usuario;

@SuppressWarnings("serial")
@Named("menuBean")
public class GerarMenu implements Serializable {
	private DefaultMenuModel model = new DefaultMenuModel();

	public DefaultMenuModel run(Usuario usuario) {
		MenuDAO menuDao = new MenuDAO();
		List<Menu> menuList = menuDao.gerarMenu(usuario);
		// ### Somente para debug via console;
		// for (Menu menu : menuList) {
		// if (menu.getIdMenuPai() == -1) {
		// System.out.println(menu.getMenu_Label());
		// menuList.stream().sorted(Comparator.comparing(Menu::getOrdem))
		// .filter(p -> p.getIdMenuPai() == menu.getId()).forEach(p -> {
		// System.out.println(p.getMenu_Label());
		// });
		// }
		// }
		// System.out.println("digite a opção desejada ou digite sair para encerrar o
		// programa.");
		//
		// String opcao = Scan.nextLine();
		// if (opcao.equals("sair")) {
		// break;
		// } else {
		// opcaoMenu(opcao);
		// }
		for (Menu menu : menuList) {
			if (menu.getIdMenuPai() == -1) {
				DefaultSubMenu submenu = new DefaultSubMenu();
				DefaultMenuItem item = new DefaultMenuItem();
				submenu.setLabel(menu.getMenu_Label());
				submenu.setId(menu.getMenu_Label());
				submenu.setRendered(true);
				menuList.stream().parallel().filter(p -> p.getIdMenuPai() == menu.getId())
						.sorted(Comparator.comparing(Menu::getOrdem)).forEach(p -> {
							item.setId(p.getId().toString());
							System.out.println(p.getMenu_Label());
							item.setValue(p.getMenu_Label());
							item.setAjax(false);
							item.setUrl("#");
							submenu.addElement(item);
						});
				System.out.println("submenu: " + submenu.getElementsCount());
				model.addElement(submenu);
			}
		}
		return model;

	}

	public DefaultMenuModel getModel() {
		return model;
	}

	public void setModel(DefaultMenuModel model) {
		this.model = model;
	}
}
