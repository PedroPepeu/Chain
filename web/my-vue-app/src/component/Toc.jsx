import { useNavigate } from "react-router-dom";

function Toc(routes) {
    const navigate = useNavigate()
    
    return (
        <aside class="sticky">
            <section>
                <div class="social acb">
                    <nav>
                        <ul>
                            <li><a href="#"><i class="fa-brands fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa-brands fa-linkedin"></i></a></li>
                            <li><a href="#"><i class="fa-brands fa-instagram"></i></a></li>
                            <li><a href="#"><i class="fa-brands fa-github"></i></a></li>
                        </ul>
                    </nav>
                </div>
                <div class="menu acb">
                    <nav>
                        <ul>
                            <li><a href="#index">Home</a></li>
                            <li><a onClick={() => navigate("/login")}>Login</a></li>
                            <li><a onClick={() => navigate("/projects")}>Projects</a></li>
                        </ul>
                    </nav>
                </div>
            </section>
        </aside>
    )
}

export default Toc