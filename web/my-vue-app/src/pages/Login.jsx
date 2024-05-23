import LoginForm from '../component/LoginForm';
import '../css/login.css'
function Login() {
    return (
        <div className='Login'>
                <div className='interfaceLogin'>
                    <div className='transparenciaLogin'>
                        <LoginForm></LoginForm>
                    </div>
                </div>
        </div>
    )
}

export default Login