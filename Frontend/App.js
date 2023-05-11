import {BrowserRouter,Route, Routes} from "react-router-dom";
import {Home} from "./pages/Home";
import {Layout} from "./pages/Layout";
import {GetAll} from "./pages/GetAll";
import {GetId} from "./pages/GetId";
import {Post} from "./pages/Post";
import {Put} from "./pages/Put";
import {Delete} from "./pages/Delete";
import {Header} from "./pages/Header";

function App() {
  return (
    <BrowserRouter>
    <Header/>
        <Routes>
            <Route path="/" element={<Layout/>}/>
            <Route index element={<Home/>}/>
            <Route path="getAll" element={<GetAll/>}/>
            <Route path="getId" element={<GetId/>}/>
            <Route path="post" element={<Post/>}/>
            <Route path="put" element={<Put/>}/>
            <Route path="delete" element={<Delete/>}/>
        </Routes>
    </BrowserRouter>
  );
}

export default App;
