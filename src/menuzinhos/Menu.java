package menuzinhos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Menu extends JFrame implements MenuListener, ActionListener
{
	private JMenuBar barraMenu; // Essa é a barra de menu
	//Em seguida, os próprios menus
	private JMenu menuCadastro, menuSobre;
	//Aqui são declarados os subitens dos menus, que depois
	//serão adicionados aos respectivos menus
	private JMenuItem menuContatos, menuSair;
	private Principal pcontatos = null;
	
	public Menu(String titulo)
	{
		super(titulo);//Aqui é a chamado ao construtor da
		//superclasse, deve ser a primeira instrução do construtor
		this.setBounds(100, 100, 456, 112);
		iniciar();
	}
	
	public void iniciar()
	{
		//Instanciando os objetos
		barraMenu = new JMenuBar();
		menuCadastro = new JMenu("Cadastro");
		menuContatos = new JMenuItem("Contatos");
		menuSair = new JMenuItem("Sair");
		menuSobre = new JMenu("Sobre");
		//Agora são adicionados os listeners respectivos
		menuCadastro.addMenuListener(this);
		menuContatos.addActionListener(this);
		menuSair.addActionListener(this);
		menuSobre.addMenuListener(this);
		menuCadastro.add(menuContatos);
		menuCadastro.add(menuSair);
		barraMenu.add(menuCadastro);
		barraMenu.add(menuSobre);
		//É configurada então a barra de menu
		this.setJMenuBar(barraMenu);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	public static void main(String[] args)
	{
		new Menu("Menu da Aplicação").setVisible(true);
		/*aqui é instanciado o objeto do tipo menu,
		 * o que é suficiente para abrir a janela,
		 * passado o titulo da mesma e configurado o modo
		 * de exibição true
		 * */
	}
	public void actionPerformed(ActionEvent e)
	{
		/*Se for clicado o item Contatos, então é testado
		 * se já está criado o objeto da janela principal e,
		 * se já estiver criado apenas é tornado visivel
		 * 
		 * senão é criado(instanciado)
		 * */
		if(e.getSource()==menuContatos)
		{
			if(pcontatos == null)
			{
				pcontatos = new Principal(this, "Menuzinhos!",true);
			}
			else
			{
				pcontatos.setVisible(true);
			}
		}
			else if(e.getSource() == menuSair)
			{
				System.exit(0);
			}
		
	}
		public void menuCanceled(MenuEvent e)
		{
			/*Aqui seria a programação que atenderia o 
			 *presente evento.
			 *Foi criado esse metodo para atender à necessidade
			 *de implementar todos os métodos abstratos da
			 *interface MenuListener
			 * */
		}
		public void menuDeselected(MenuEvent e)
		{
			/*Esse código acontece quando o menu
			 * perde o foco que estava sobre ele
			 * */
			if (e.getSource() == menuCadastro)
			{
				System.out.println("Menu cadastro desselecionado");
			}else if(e.getSource()==menuSobre)
			{
				System.out.println("menu sobre desselecionado");
			}
		}
		public void menuSelected(MenuEvent e)
		{
			/*Aqui são trabalhados os eventos de clique
			 * nos menus propriamente ditos. Observe que
			 * aqui só são tratados os menus de primeiro
			 * nivel, e não seus sub itens...
			 * */
			if(e.getSource()==menuCadastro)
			{
				/*aqui podem ser instanciadas e chamadas outras
				 * janelas(filhas de JFrame) mas nesse exemplo
				 * apenas estamos exibindo mensagens com fins
				 * didáticos
				 * */
				System.out.println("Menu cadastro Acionado");
			}else if (e.getSource()==menuSobre)
			{
				System.out.println("Menu Sobre Acionado");
				JOptionPane.showMessageDialog(this,"Créditos JAVA"
						+ "Avançado");
			}
		}
}