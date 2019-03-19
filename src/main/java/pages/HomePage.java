package pages;

import org.openqa.selenium.By;

import uteis.BasePage;

public class HomePage extends BasePage{

	/*Menu Lateral*/
	
	public void clicaBotaoMinhaVisao() { 
   	 clicar(By.cssSelector("#sidebar > ul > li.active > a > i"));
   }
	public void clicaBotaoVerTarefas() { 
   	 clicar(By.cssSelector("#sidebar > ul > li:nth-child(2) > a > span"));
   }
	public void clicaBotaoCriarTarefas() { 
		 clicar(By.cssSelector("#sidebar > ul > li:nth-child(3) > a > span"));
   }
	public void clicaBotaoRegistroDeMudancas() { 
		 clicar(By.cssSelector("#sidebar > ul > li:nth-child(4) > a > span"));
   }
	public void clicaBotaoPlanejamento() { 
		 clicar(By.cssSelector("#sidebar > ul > li:nth-child(5) > a > span"));
   }
	public void clicaBotaoResumo() { 
		 clicar(By.cssSelector("#sidebar > ul > li:nth-child(6) > a > span"));
   }
	public void clicaBotaoGerenciar() { 
		 clicar(By.cssSelector("#sidebar > ul > li:nth-child(7) > a > span"));
   }
	
	
	/*Metodos
     public void clicaBotaoZZZ() { 
    	 clicar(by);
    }

     public void clicaBotaoNaoAtribuidos() { 
    	 uteis.clicaBotao(BotaoNaoAtribuidos, uteis.RetornaNomeVariavel(() => BotaoNaoAtribuidos)); 
     }

     public void clicaBotaoRelatadosPorMim() {
    	 uteis.clicaBotao(BotaoRelatadosPorMim, uteis.RetornaNomeVariavel(() => BotaoRelatadosPorMim)); 
    }

     public void clicaBotaoResolvidos() { 
    	 uteis.clicaBotao(BotaoResolvidos, uteis.RetornaNomeVariavel(() => BotaoResolvidos)); 
     }

     public void clicaBotaoModificadosRecentemente() { 
    	 uteis.clicaBotao(BotaoModificadosRecentemente, uteis.RetornaNomeVariavel(() => BotaoModificadosRecentemente)); 
    }

     public void clicaBotaoMonitoradosPorMim() { uteis.clicaBotao(BotaoMonitoradosPorMim, uteis.RetornaNomeVariavel(() => BotaoMonitoradosPorMim)); }

     */
	
}
