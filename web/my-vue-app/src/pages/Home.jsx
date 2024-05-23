import Header from "../component/Header";
import Footer from "../component/Footer";
import Toc from "../component/Toc";

import 'bootstrap/dist/css/bootstrap.min.css'
import '../assets/fontawesome/css/brands.css'
import '../assets/fontawesome/css/solid.css'
import '../assets/fontawesome/css/fontawesome.css'

function Home() {


    return (
      <>
        <body>
          <div className='main-wrapper'>
            <div className='top-wrapper'>
              <Header></Header>
            </div>
            <div className='middle-wrapper'>
              <div className="main-container">
                <div className="main-content">
                  <h1>Eu ainda vou mudar essa página v0.1</h1>
                  <p>Desenvolver um software é uma tarefa complexa que muitas vezes envolve o uso de vários aplicativos diferentes, porém às vezes é complicado gerenciar todos os aplicativos e engenheiros de software de um projeto. Para resolver esse problema, foi idealizada a criação de um site que interligasse todos os outros aplicativos e engenheiros de software, para ajudar a melhorar a organização de um projeto de software.
                    Nesse site seria possível a criação de projetos em que pudessem ser adicionados os links dos outros aplicativos, unificando mais o projeto. Além disso, dentro dos projetos seria possível adicionar as diversas atividades necessárias e administrar o que cada engenheiro de software deve fazer. Essas atividades ajudariam a mapear o andamento do projeto e cada engenheiro poderia ver quais são as tarefas que faltam ser realizadas a partir de um calendário.
                  </p>
                </div>
                <Toc></Toc>
              </div>
            </div>
            <div className='bottom-wrapper'>
              <Footer></Footer>
            </div>
          </div>
        </body>
      </>
    );
  }
  
  export default Home
  