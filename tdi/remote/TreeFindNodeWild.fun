Public fun TreeFindNodeWild(in _path, optional _usagemask)
{
  _ctx = 0;
  _nid = 0;
  _nids = *;
  if (!present(_usagemask)) _usagemask = -1;
  _status = TreeShr->TreeFindNodeWild(ref(_path//"\0"), ref(_nid), ref(_ctx), val(_usagemask));
  if (_status & 1)
  {
    _nids = [_nid];
    while (TreeShr->TreeFindNodeWild(ref(_path//"\0"), ref(_nid), ref(_ctx), val(_usagemask)) & 1) _nids = [_nids, _nid];
  }
  TreeShr->TreeFindNodeEnd(_ctx);
  return(_nids);
}
